package org.example.BusinessObjects;

import org.example.DTOs.Cow;
import org.example.Exceptions.DaoExceptions;
import org.example.SortType;
import org.example.milkYieldComparator;

import java.io.IOException;
import java.util.*;
import java.util.PriorityQueue;
import org.example.DAOs.MySqlCowDao;
import org.example.DAOs.CowDaoInterface;
import org.example.DTOs.Cow;
import java.util.List;

/**
 * Hello world!
 *
 */
@SuppressWarnings("unchecked")
public class App {
    public static void main(String[] args) throws DaoExceptions {
        //App app = new App();
        //app.start();
        CowDaoInterface ICowDao = new MySqlCowDao();

        try {
            System.out.println("\nCall findAllCows()");
            List<Cow> cows_ = ICowDao.findAllCows();
            if (cows_.isEmpty()) {
                System.out.println("There are no cows");
            } else {
                for (Cow cow : cows_) {
                    System.out.println("Cow: " + cow.toString());
                }
            }

            System.out.println("\nCall: findCowByTagID()");
            Scanner keyboard = new Scanner(System.in);
            int tag_id;
            System.out.println("Enter tag ID: ");
            tag_id = keyboard.nextInt();
            Cow cow_ = ICowDao.findCowByTagID(tag_id);
            if (cow_ != null) {
                System.out.println("Cow found: " + cow_);
            } else {
                System.out.println("Tag ID was not found");
            }


        } catch (DaoExceptions e) {
            e.printStackTrace();
        }

        System.out.println("\nCall: addCow()");
        Cow cows_ = ICowDao.addCow(450, "female", "angus", 2018, 11, 3, 6);
        if (cows_ != null) {
            System.out.println("Cow found: " + cows_);
        } else {
            System.out.println("Tag ID was not found");
        }


        System.out.println("\nCall: deleteCow()");
        Scanner keyboard = new Scanner(System.in);
        int tag_id__;
        System.out.println("Enter tag ID: ");
        tag_id__ = keyboard.nextInt();
        Cow cow__ = ICowDao.deleteCow(tag_id__);
        if (cow__ != null) {
            System.out.println("Cow found: " + cow__);
        } else {
            System.out.println("Tag ID was not found");
        }

        System.out.println("\nfindCowsUsingFilter()");
        keyboard = new Scanner(System.in);
        int milkYield_;
        System.out.println("Enter milk yield: ");
        milkYield_ = keyboard.nextInt();
        List<Cow> cowsFilter = ICowDao.findCowsUsingFilter();
        if (cowsFilter.isEmpty()) {
            System.out.println("There are no cows with milk yield greater than " + milkYield_);
        } else {
            for (Cow cow : cowsFilter) {
                if (cow.getMilkYields() == milkYield_)
                    System.out.println("Cow: " + cow.toString());
            }
        }

        System.out.println("\nDisplayCowsInJSON()");
        String allCowsJSON = ICowDao.findAllCowsJSON();
        System.out.println(allCowsJSON);


        System.out.println("\nfindCowByTagIDJSON()");
        int tag_id_;
        System.out.println("Enter tag ID: ");
        tag_id_ = keyboard.nextInt();
        String JSON = ICowDao.findCowByTagIDJSON(tag_id_);
        System.out.println(JSON);
    }

    public void start() throws IOException {
        displayMainMenu();
    }

    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. Hash Map\n"
                + "2. Tree Map\n"
                + "3. Priority Queue\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int HASHMAP = 1;
        final int TREEMAP = 2;
        final int PRIORITY_QUEUE = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case HASHMAP:
                        System.out.println("Hash Map option chosen");
                        displayHashMapMenu();
                        break;
                    case TREEMAP:
                        System.out.println("Tree Map option chosen");
                        displayTreeMapMenu();
                        break;
                    case PRIORITY_QUEUE:
                        System.out.println("Priority Queue option chosen");
                        displayPriorityQueueMenu();
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");
    }

    private void displayHashMapMenu() {
        Cow cow1 = new Cow(224, "female", "angus", 2019, 2, 3, 6);
        Cow cow2 = new Cow(225, "female", "jersey", 2019, 2, 8, 20);
        Cow cow3 = new Cow(226, "female", "jersey", 2019, 2, 11, 20);
        Cow cow4 = new Cow(227, "female", "angus", 2018, 11, 21, 6);
        Cow cow5 = new Cow(178, "female", "friesian", 2018, 11, 24, 32);
        Cow cow6 = new Cow(179, "female", "friesian", 2018, 11, 25, 32);
        Cow cow7 = new Cow(180, "female", "friesian", 2018, 11, 30, 32);
        Cow cow8 = new Cow(181, "female", "friesian", 2021, 2, 2, 32);
        Cow cow9 = new Cow(363, "female", "hereford", 2021, 2, 6, 27);
        Cow cow10 = new Cow(634, "female", "hereford", 2021, 2, 7,27);

        ArrayList<Cow> cowslist = new ArrayList<>();
        cowslist.add(cow1);
        cowslist.add(cow2);
        cowslist.add(cow3);
        cowslist.add(cow4);
        cowslist.add(cow5);
        cowslist.add(cow6);
        cowslist.add(cow7);
        cowslist.add(cow8);
        cowslist.add(cow9);
        cowslist.add(cow10);

        ArrayList<Integer> farmerIDs = new ArrayList<>();
        farmerIDs.add(23953);
        farmerIDs.add(42133);
        farmerIDs.add(42690);
        farmerIDs.add(82080);
        farmerIDs.add(29060);
        farmerIDs.add(37426);
        farmerIDs.add(34799);
        farmerIDs.add(52012);
        farmerIDs.add(83391);
        farmerIDs.add(82080);

        Map<Integer, Cow> CowHashMap =  new HashMap<>();

        final String MENU_ITEMS = "\n*** HASH MAP MENU ***\n"
                + "1. Create Hash Map\n"
                + "2. Display All Elements\n"
                + "3. Get Hash Map Object By Key\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int CREATE_HASH_MAP = 1;
        final int DISPLAY_ALL_ELEMENTS_IN_HASH_MAP = 2;
        final int GET_OBJECT_BY_KEY = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("\n"+MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case CREATE_HASH_MAP:
                        CowHashMap = hashMap(cowslist, farmerIDs);
                        break;
                    case DISPLAY_ALL_ELEMENTS_IN_HASH_MAP:
                        displayAllCowsInHashMap(CowHashMap);
                        break;
                    case GET_OBJECT_BY_KEY:
                        getHashMapObjectByKey(CowHashMap);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException |NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    private void displayTreeMapMenu() {
        Cow cow1 = new Cow(224, "female", "angus", 2019, 2, 3, 6);
        Cow cow2 = new Cow(225, "female", "jersey", 2019, 2, 8, 20);
        Cow cow3 = new Cow(226, "female", "jersey", 2019, 2, 11, 20);
        Cow cow4 = new Cow(227, "female", "angus", 2018, 11, 21, 6);
        Cow cow5 = new Cow(178, "female", "friesian", 2018, 11, 24, 32);
        Cow cow6 = new Cow(179, "female", "friesian", 2018, 11, 25, 32);
        Cow cow7 = new Cow(180, "female", "friesian", 2018, 11, 30, 32);
        Cow cow8 = new Cow(181, "female", "friesian", 2021, 2, 2, 32);
        Cow cow9 = new Cow(363, "female", "hereford", 2021, 2, 6, 27);
        Cow cow10 = new Cow(634, "female", "hereford", 2021, 2, 7,27);

        ArrayList<Cow> cowslist = new ArrayList<>();
        cowslist.add(cow1);
        cowslist.add(cow2);
        cowslist.add(cow3);
        cowslist.add(cow4);
        cowslist.add(cow5);
        cowslist.add(cow6);
        cowslist.add(cow7);
        cowslist.add(cow8);
        cowslist.add(cow9);
        cowslist.add(cow10);

        ArrayList<Integer> farmerIDs = new ArrayList<>();
        farmerIDs.add(23953);
        farmerIDs.add(42133);
        farmerIDs.add(42690);
        farmerIDs.add(82080);
        farmerIDs.add(29060);
        farmerIDs.add(37426);
        farmerIDs.add(34799);
        farmerIDs.add(52012);
        farmerIDs.add(83391);
        farmerIDs.add(82080);

        Map<Integer, Cow> CowTreeMap = new TreeMap<>();

        final String MENU_ITEMS = "\n*** TREE MAP MENU ***\n"
                + "1. Create Tree Map\n"
                + "2. Display All Elements\n"
                + "3. Get Hash Map Object By Key\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int CREATE_TREE_MAP = 1;
        final int DISPLAY_ALL_ELEMENTS_IN_TREE_MAP = 2;
        final int GET_OBJECT_BY_KEY = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("\n"+MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case CREATE_TREE_MAP:
                        CowTreeMap = treeMap(cowslist, farmerIDs);
                        break;
                    case DISPLAY_ALL_ELEMENTS_IN_TREE_MAP:
                        displayAllCowsInTreeMap(CowTreeMap);
                        break;
                    case GET_OBJECT_BY_KEY:
                        getTreeMapObjectByKey(CowTreeMap);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException |NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    private void displayPriorityQueueMenu() {
        Cow cow1 = new Cow(224, "female", "angus", 2019, 2, 3, 6);
        Cow cow2 = new Cow(225, "female", "jersey", 2019, 2, 8, 20);
        Cow cow3 = new Cow(226, "female", "jersey", 2019, 2, 11, 20);
        Cow cow4 = new Cow(227, "female", "angus", 2018, 11, 21, 6);
        Cow cow5 = new Cow(178, "female", "friesian", 2018, 11, 24, 32);
        Cow cow6 = new Cow(179, "female", "friesian", 2018, 11, 25, 32);
        Cow cow7 = new Cow(180, "female", "friesian", 2018, 11, 30, 32);
        Cow cow8 = new Cow(181, "female", "friesian", 2021, 2, 2, 32);
        Cow cow9 = new Cow(363, "female", "hereford", 2021, 2, 6, 27);
        Cow cow10 = new Cow(634, "female", "hereford", 2021, 2, 7,27);

        ArrayList<Cow> cowslist = new ArrayList<>();
        cowslist.add(cow1);
        cowslist.add(cow2);
        cowslist.add(cow3);
        cowslist.add(cow4);
        cowslist.add(cow5);
        cowslist.add(cow6);
        cowslist.add(cow7);
        cowslist.add(cow8);
        cowslist.add(cow9);
        cowslist.add(cow10);

        PriorityQueue<Cow> CowPriorityQueue = new PriorityQueue<>(new milkYieldComparator());

        final String MENU_ITEMS = "\n*** PRIORITY QUEUE MENU ***\n"
                + "1. Create Priority Queue\n"
                + "2. Display All Elements\n"
                + "3. Add 2 Third Priority Elements\n"
                + "4. Add 2 Second Priority Elements\n"
                + "5. Remove And Display 1 Element\n"
                + "6. Display All Elements In Priority Order\n"
                + "7. Exit\n"
                + "Enter Option [1,7]";

        final int CREATE_PRIORITY_QUEUE = 1;
        final int DISPLAY_ALL_ELEMENTS_IN_PRIORITY_QUEUE = 2;
        final int ADD_2_THIRD_PRIORITY_ELEMENTS = 3;
        final int ADD_2_SECOND_PRIORITY_ELEMENTS = 4;
        final int REMOVE_AND_DISPLAY_1_ELEMENT = 5;
        final int DISPLAY_ALL_ELEMENTS_IN_PRIORITY_ORDER = 6;
        final int EXIT = 7;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("\n"+MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case CREATE_PRIORITY_QUEUE:
                        CowPriorityQueue = priorityQueue(cowslist);
                        break;
                    case DISPLAY_ALL_ELEMENTS_IN_PRIORITY_QUEUE:
                        displayAllCowsInPriorityQueue(CowPriorityQueue);
                        break;
                    case ADD_2_THIRD_PRIORITY_ELEMENTS:
                        add2ThirdPriorityElements(CowPriorityQueue);
                        displayAllCowsInPriorityQueue(CowPriorityQueue);
                        break;

                    case ADD_2_SECOND_PRIORITY_ELEMENTS:
                        add2SecondPriorityElements(CowPriorityQueue);
                        displayAllCowsInPriorityQueue(CowPriorityQueue);
                        break;

                    case REMOVE_AND_DISPLAY_1_ELEMENT:
                        removeAndDisplayOneElement(CowPriorityQueue, cow1);
                        displayAllCowsInPriorityQueue(CowPriorityQueue);
                        break;

                    case DISPLAY_ALL_ELEMENTS_IN_PRIORITY_ORDER:
                        displayCowPriorityQueueBasedOnPriority(CowPriorityQueue);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException |NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    public void displayAllCows (ArrayList < Cow > cows)
    {
        System.out.println("display all cows in arraylist");
        for (Cow c : cows) {
            System.out.println(c);
        }
    }


    public void displayAllFarmerIDs(ArrayList<String> farmerIDs)
    {
        System.out.println("display all farmer IDs in arraylist");
        for(String id : farmerIDs)
        {
            System.out.println(id);
        }
    }

    public Map<Integer, Cow> hashMap(ArrayList<Cow> cowslist, ArrayList<Integer> farmerIDs)
    {
        Map<Integer, Cow> CowHashMap = new HashMap<>();
        for(int i =0; i < cowslist.size(); i++)
        {
            Cow x = cowslist.get(i);
            int y = farmerIDs.get(i);
            CowHashMap.put(y, x);
        }
        return CowHashMap;
    }
    public void displayAllCowsInHashMap(Map<Integer, Cow> CowHashMap)
    {
        System.out.println("display cows in hash map");
        Set<Integer> keySet = CowHashMap.keySet();
        for (int key : keySet)
        {
            Cow value = CowHashMap.get(key);
            System.out.println(key + " : " + value);
        }
    }

    public static void getHashMapObjectByKey(Map<Integer, Cow> CowHashMap)
    {
        Set<Integer> keySet = CowHashMap.keySet();
        for (int key : keySet) {
            Cow value = CowHashMap.get(key);
            System.out.println(key + " : " + value);
        }

        String key = "O08208Y";
        if (CowHashMap.containsKey(key))
        {
            System.out.println("CowHashMap contains the key" + key + " with value " + CowHashMap.get(key));
        }
        else
        {
            System.out.println("CowHashMap does NOT contain the key " + key);
        }
    }

    public Map<Integer, Cow> treeMap(ArrayList<Cow> cowslist, ArrayList<Integer> farmerIDs)
    {
        Map<Integer, Cow> CowTreeMap = new TreeMap<>();
        for(int i =0; i < cowslist.size(); i++)
        {
            Cow x = cowslist.get(i);
            int y = farmerIDs.get(i);
            CowTreeMap.put(y, x);
        }
        return CowTreeMap;
    }
    public void displayAllCowsInTreeMap(Map<Integer, Cow> CowTreeMap)
    {
        System.out.println("display cows in tree map");
        Set<Integer> keySet = CowTreeMap.keySet();
        for (int key : keySet) {
            Cow value = CowTreeMap.get(key);
            System.out.println(key + " : " + value);
        }
    }

    public void getTreeMapObjectByKey(Map<Integer, Cow> CowTreeMap)
    {
        Set<Integer> keySet = CowTreeMap.keySet();
        for (int key : keySet) {
            Cow value = CowTreeMap.get(key);
            System.out.println(key + " : " + value);
        }

        int key = 82080;
        if (CowTreeMap.containsKey(key)) {
            System.out.println("CowHashMap contains the key" + key + " with value " + CowTreeMap.get(key));
        } else {
            System.out.println("CowHashMap does NOT contain the key " + key);
        }
    }

    public PriorityQueue<Cow> priorityQueue(ArrayList<Cow> cowslist)
    {
        PriorityQueue<Cow> priorityQueue= new PriorityQueue<>(new milkYieldComparator());
        priorityQueue.addAll(cowslist);
        return priorityQueue;
    }

    public void displayAllCowsInPriorityQueue(PriorityQueue<Cow> CowPriorityQueue)
    {
        System.out.println("display priority queue");
        for (Cow cow : CowPriorityQueue) {
            System.out.println(cow + ", ");
        }
    }

    public void add2ThirdPriorityElements(PriorityQueue<Cow> CowPriorityQueue)
    {
        Cow cow11 = new Cow(324, "female", "jersey", 2020, 4, 1, 20);
        Cow cow12 = new Cow(325, "female", "jersey", 2020, 4, 6, 20);
        CowPriorityQueue.add(cow11);
        CowPriorityQueue.add(cow12);
    }

    public void add2SecondPriorityElements(PriorityQueue<Cow> CowPriorityQueue)
    {
        Cow cow13 = new Cow(312, "female", "hereford", 2020, 11, 29, 27);
        Cow cow14 = new Cow(313, "female", "hereford", 2021, 1, 6, 27);
        CowPriorityQueue.add(cow13);
        CowPriorityQueue.add(cow14);
        displayAllCowsInPriorityQueue(CowPriorityQueue);
    }

    public void removeAndDisplayOneElement(PriorityQueue<Cow> CowPriorityQueue, Cow cow1)
    {
        CowPriorityQueue.remove(cow1);
    }

    public void displayCowPriorityQueueBasedOnPriority(PriorityQueue<Cow> CowPriorityQueue)
    {
        System.out.println("Display Priority Queue In Priority Order");
        while (!CowPriorityQueue.isEmpty())
            System.out.println(CowPriorityQueue.remove());

        if (CowPriorityQueue.isEmpty())
            System.out.println("The priorityQueue is now empty.");
    }



}
