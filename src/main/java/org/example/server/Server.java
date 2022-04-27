package org.example.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.DAOs.CowDaoInterface;
import org.example.DAOs.MySqlCowDao;
import org.example.DTOs.Cow;
import org.example.DTOs.Schema;
import org.example.Exceptions.DaoExceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Server
{
    public static void main(String[] args)
    {
        Server server = new Server();
        server.start();
    }

    public void start()
    {
        CowDaoInterface dao = new MySqlCowDao();
        try
        {
            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection,
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber, dao)); // create a new ClientHandler for the client,
                t.start();                                                  // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e)
        {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;
        CowDaoInterface dao;

        public ClientHandler(Socket clientSocket, int clientNumber, CowDaoInterface dao)
        {
            this.dao = dao;
            try
            {
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);

                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

                this.clientNumber = clientNumber;  // ID number that we are assigning to this client

                this.socket = clientSocket;  // store socket ref for closing

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            String message;
            try
            {
                while ((message = socketReader.readLine()) != null)
                {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);

                    if (message.startsWith("DisplayAllCows"))
                    {
                        Gson gsonParser = new Gson();
                        String JsonString = "";
                        List<Cow> cows_ = dao.findAllCows();
                        if (cows_.isEmpty())
                        {
                            socketWriter.println("There are no cows in the database.");
                        }
                        else
                        {
                            JsonString = gsonParser.toJson(cows_);
                            socketWriter.println("Cows found: " + JsonString);
                        }
                    }
                    else if (message.startsWith("getOneCow"))
                    {
                        Gson gsonParser = new Gson();
                        String JsonString = "";
                        String[] tokens = message.split(" ");
                        int id = Integer.parseInt(tokens[1]);
                        Cow cow_ = dao.findCowByTagID(id);
                        if (cow_ != null)
                        {
                            JsonString = gsonParser.toJson(cow_);
                            socketWriter.println("Cow found: " + JsonString);
                        }
                        else
                        {
                            socketWriter.println("Cow could not be found.");
                        }
                    }
                    else if(message.startsWith("addCow"))
                    {
                        Gson gsonParser = new Gson();
                        String JsonString = "";
                        String[] tokens = message.split(" ");
                        int id = Integer.parseInt(tokens[1]);
                        String sex = tokens[2];
                        String breed = tokens[3];
                        int year = Integer.parseInt(tokens[4]);
                        int month = Integer.parseInt(tokens[5]);
                        int day = Integer.parseInt(tokens[6]);
                        int milkYield = Integer.parseInt(tokens[7]);
                        Cow cows_ = dao.addCow(id, sex, breed, year, month, day, milkYield);
                        if (cows_ != null)
                        {

                            JsonString = gsonParser.toJson(cows_);
                            socketWriter.println("Cow added: " + JsonString);
                        }
                        else
                        {
                            socketWriter.println("Cow could not be added.");
                        }
                    }
                    else if(message.startsWith("deleteCow"))
                    {
                        Gson gsonParser = new Gson();
                        String JsonString = "";
                        String[] tokens = message.split(" ");
                        int id = Integer.parseInt(tokens[1]);
                        List<Cow> cows_ = dao.deleteCow(id);
                        if (cows_ != null)
                        {
                            JsonString = gsonParser.toJson(cows_);
                            socketWriter.println("Cow removed from list: " + JsonString);;
                        }
                        else
                        {
                            socketWriter.println("Cow could not be deleted.");
                        }
                    }
                    else if(message.startsWith("filterCow"))
                    {
                        String[] tokens = message.split(" ");
                        int milkYield_ = Integer.parseInt(tokens[1]);
                        System.out.println("Milk yield: " + milkYield_);
                        List<Cow> cowsFilter = dao.findCowsUsingFilter();
                        System.out.println("cows length: " + cowsFilter.size());
                        ArrayList<Cow> cowsfiltered = new ArrayList<Cow>();
                        Gson gsonParser = new Gson();
                        String JsonString = "";
                        if (cowsFilter.isEmpty())
                        {
                            socketWriter.println("There are no cows with milk yield greater than " + milkYield_);
                        } else
                        {
                            for (Cow cow : cowsFilter)
                            {
                                if (cow.getMilkYields() == milkYield_)
                                {
                                    cowsfiltered.add(cow);
                                }
                            }
                            JsonString = gsonParser.toJson(cowsfiltered);
                            socketWriter.println(JsonString);
                        }
                    }
                    else if (message.startsWith("Schema"))
                    {
                        Gson gsonParser = new Gson();
                        String JsonString = "";
                        List<Schema> schemaList = dao.getInformationSchema();
                        if (schemaList.isEmpty())
                        {
                            System.out.println("There are no schema for this database.");
                        }
                        else
                        {
                            JsonString = gsonParser.toJson(schemaList);
                            socketWriter.println("Schema found: " + JsonString);
                        }
                    }
                    else
                    {
                        socketWriter.println("I'm sorry I don't understand :(");
                    }
                }
                socket.close();

            } catch (IOException | DaoExceptions ex)
            {
                ex.printStackTrace();
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

}

