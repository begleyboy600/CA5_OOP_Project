package org.example.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 8080);  // connect to server socket
            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort());

            System.out.println("Client message: The Client is running and has connected to the server");

            System.out.println("Please enter a command:  \n" +
                    "\"DisplayAllCows\" to display all cows \n" +
                    "\"getOneCow\" (followed by a tag ID) to display one cow \n" +
                    "\"addCow\" (followed by tag_ID, sex, breed, (year, month, day) of birth and milk yield) to add cow to database \n" +
                    "\"deleteCow\" (followed by tag_ID) to delete a cow \n" +
                    "\"filterCow\" (followed by milk yield) to display all cows with the specified milk yield \n" +
                    "\"Schema\" to get all information about the each column of data within the database \n" +
                    "\"Echo message\" to get echo \n" +
                    ">");
            String command = in.nextLine();

            OutputStream os = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);   // true => auto flush buffers

            socketWriter.println(command);

            Scanner socketReader = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply

            boolean continueLoop = true;
            while (continueLoop)
            {
                if(command.startsWith("DisplayAllCows"))
                {
                    System.out.println("Client: Display all cows");
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                else if(command.startsWith("getOneCow"))
                {
                    System.out.println("Client: getOneCow");
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                else if(command.startsWith("addCow"))
                {
                    System.out.println("Client: addCow");
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                else if(command.startsWith("deleteCow"))
                {
                    System.out.println("Client: deleteCow");
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                else if(command.startsWith("filterCow"))
                {
                    System.out.println("Client: filterCow");
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                else if(command.startsWith("Schema"))
                {
                    System.out.println("Client: Schema");
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                else// the user has entered the Echo command or an invalid command
                {
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                System.out.println("Please enter a command:  \n" +
                        "\"DisplayAllCows\" to display all cows \n" +
                        "\"getOneCow\" (followed by a tag ID) to display one cow \n" +
                        "\"addCow\" (followed by tag_ID, sex, breed, (year, month, day) of birth and milk yield) to add cow to database \n" +
                        "\"deleteCow\" (followed by tag_ID) to delete a cow \n" +
                        "\"filterCow\" (followed by milk yield) to display all cows with the specified milk yield \n" +
                        "\"Schema\" to get all information about the each column of data within the database \n" +
                        "\"Echo message\" to get echo \n" +
                        ">");
                command = in.nextLine();
                socketWriter.println(command);
            }
            socketWriter.close();
            socketReader.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Client message: IOException: " + e);
        }
    }
}