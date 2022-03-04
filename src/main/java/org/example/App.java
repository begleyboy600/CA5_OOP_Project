package org.example;

import java.util.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.start();

    }
    public void start()
    {
        Cow cow1 = new Cow(224, "male", "angus", 2019, 2, 3);
        Cow cow2 = new Cow(225, "female", "jersey", 2019, 2, 8);
        Cow cow3 = new Cow(226, "female", "jersey", 2019, 2, 11);
        Cow cow4 = new Cow(227, "male", "angus", 2018, 11, 21);
        Cow cow5 = new Cow(178, "female", "friesian", 2018, 11, 24);

        Cow cow6 = new Cow(179, "female", "friesian", 2018, 11, 25);
        Cow cow7 = new Cow(180, "female", "friesian", 2018, 11, 30);
        Cow cow8 = new Cow(181, "female", "friesian", 2021, 2, 2);
        Cow cow9 = new Cow(363, "male", "hereford", 2021, 2, 6);
        Cow cow10 = new Cow(634, "male", "hereford", 2021, 2, 7);

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
        displayAllCows(cowslist);

        ArrayList<String> farmerIDs = new ArrayList<>();
        farmerIDs.add("O23953Y");
        farmerIDs.add("O42133Y");
        farmerIDs.add("O42690Y");
        farmerIDs.add("O08208Y");
        farmerIDs.add("O02906Y");

        farmerIDs.add("O37426Y");
        farmerIDs.add("O34799Y");
        farmerIDs.add("O52012Y");
        farmerIDs.add("O83391Y");
        farmerIDs.add("O08208Y");
        displayAllFarmerIDs(farmerIDs);

        Map<String, Cow> CowHashMap = hashMap(cowslist, farmerIDs);
        displayAllCowsInHashMap(CowHashMap);
        getHashMapObjectByKey(CowHashMap);

        Map<String, Cow> CowTreeMap = treeMap(cowslist, farmerIDs);
        displayAllCowsInTreeMap(CowTreeMap);
        getTreeMapObjectByKey(CowTreeMap);

        PriorityQueue<Cow> CowPriorityQueue = priorityQueue(cowslist);
        displayAllCowsInPriorityQueue(CowPriorityQueue);
        priorityQueueTagIDComparator(CowPriorityQueue);

    }
    public void displayAllCows(ArrayList<Cow> cows)
    {
        for(Cow c : cows)
        {
            System.out.println(c);
        }
    }

    public void displayAllFarmerIDs(ArrayList<String> farmerIDs)
    {
        for(String id : farmerIDs)
        {
            System.out.println(id);
        }
    }

    public Map<String, Cow> hashMap(ArrayList<Cow> cowslist, ArrayList<String> farmerIDs)
    {
        Map<String, Cow> CowHashMap = new HashMap<>();
        // String is the farmers herd id

        for (Cow cow : cowslist)
        {
            for (String farmerID : farmerIDs)
            {
                CowHashMap.put(farmerID, cow);
            }
        }
        return CowHashMap;
    }
    public void displayAllCowsInHashMap(Map<String, Cow> CowHashMap)
    {
        Set<String> keySet = CowHashMap.keySet();
        for (String key : keySet)
        {
            Cow value = CowHashMap.get(key);
            System.out.println(key + " : " + value);
        }
    }

    public static void getHashMapObjectByKey(Map<String, Cow> CowHashMap)
    {
        Set<String> keySet = CowHashMap.keySet();
        for (String key : keySet) {
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

    public Map<String, Cow> treeMap(ArrayList<Cow> cowslist, ArrayList<String> farmerIDs)
    {
        Map<String, Cow> CowTreeMap = new TreeMap<>();
        // String is the farmers herd id

        for (Cow cow : cowslist)
        {
            for (String farmerID : farmerIDs)
            {
                CowTreeMap.put(farmerID, cow);
            }
        }
        return CowTreeMap;
    }
    public void displayAllCowsInTreeMap(Map<String, Cow> CowTreeMap)
    {
        Set<String> keySet = CowTreeMap.keySet();
        for (String key : keySet) {
            Cow value = CowTreeMap.get(key);
            System.out.println(key + " : " + value);
        }
    }

    public static void getTreeMapObjectByKey(Map<String, Cow> CowTreeMap)
    {
        Set<String> keySet = CowTreeMap.keySet();
        for (String key : keySet) {
            Cow value = CowTreeMap.get(key);
            System.out.println(key + " : " + value);
        }

        String key = "O08208Y";
        if (CowTreeMap.containsKey(key)) {
            System.out.println("CowHashMap contains the key" + key + " with value " + CowTreeMap.get(key));
        } else {
            System.out.println("CowHashMap does NOT contain the key " + key);
        }
    }

    public PriorityQueue<Cow> priorityQueue(ArrayList<Cow> cowslist)
    {
        PriorityQueue<Cow> priorityQueue= new PriorityQueue<>(new CowTagIDComparator(SortType.Ascending));
        priorityQueue.addAll(cowslist);
        return priorityQueue;
    }

    public void displayAllCowsInPriorityQueue(PriorityQueue<Cow> CowPriorityQueue)
    {
        for (Cow cow : CowPriorityQueue) {
            System.out.print(cow + ", ");
        }
        System.out.println();
    }

    public void priorityQueueTagIDComparator(PriorityQueue<Cow> CowPriorityQueue)
    {
        System.out.println("Values in order of tag id:");
        while ( !CowPriorityQueue.isEmpty() )
        {
            System.out.println(CowPriorityQueue.remove());
        }
    }



}
