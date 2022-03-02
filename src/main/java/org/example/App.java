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
        //Map<String, Cow> CowHashMap = hashMap(cow1, cow2, cow3, cow4, cow5, cow6, cow7, cow8, cow9, cow10);
        //getHashMapObjectByKey(CowHashMap);
        //Map<String, Cow> CowTreeMap = treeMap(cow1, cow2, cow3, cow4, cow5, cow6, cow7, cow8, cow9, cow10);
        //getTreeMapObjectByKey(CowTreeMap);
        PriorityQueue<Cow> CowPriorityQueue = priorityQueue(cow1, cow2, cow3, cow4, cow5, cow6, cow7, cow8, cow9, cow10);


    }
    public void displayAllCows(ArrayList<Cow> cows)
    {
        for(Cow c : cows)
        {
            System.out.println(c);
        }
    }

    public Map<String, Cow> hashMap(Cow cow1, Cow cow2, Cow cow3, Cow cow4, Cow cow5, Cow cow6, Cow cow7, Cow cow8,
                                    Cow cow9, Cow cow10)
    {
        Map<String, Cow> CowHashMap = new HashMap<>();
        // String is the farmers herd id
        CowHashMap.put("O23953Y", cow1);
        CowHashMap.put("O42133Y", cow2);
        CowHashMap.put("O42690Y", cow3);
        CowHashMap.put("O08208Y", cow4);
        CowHashMap.put("O02906Y", cow5);
        CowHashMap.put("O37426Y", cow6);
        CowHashMap.put("O96826Y", cow7);
        CowHashMap.put("O34799Y", cow8);
        CowHashMap.put("O52012Y", cow9);
        CowHashMap.put("O83391Y", cow10);
        return CowHashMap;
    }

    public static void getHashMapObjectByKey(Map<String, Cow> CowHashMap)
    {
        Set<String> keySet = CowHashMap.keySet();
        for (String key : keySet) {
            Cow value = CowHashMap.get(key);
            System.out.println(key + " : " + value);
        }

        String key = "O08208Y";
        if (CowHashMap.containsKey(key)) {
            System.out.println("CowHashMap contains the key" + key + " with value " + CowHashMap.get(key));
        } else {
            System.out.println("CowHashMap does NOT contain the key " + key);
        }
    }

    public Map<String, Cow> treeMap(Cow cow1, Cow cow2, Cow cow3, Cow cow4, Cow cow5, Cow cow6, Cow cow7, Cow cow8,
                                    Cow cow9, Cow cow10)
    {
        Map<String, Cow> CowTreeMap = new TreeMap<>();
        CowTreeMap.put("O23953Y", cow1);
        CowTreeMap.put("O42133Y", cow2);
        CowTreeMap.put("O42690Y", cow3);
        CowTreeMap.put("O08208Y", cow4);
        CowTreeMap.put("O02906Y", cow5);
        CowTreeMap.put("O37426Y", cow6);
        CowTreeMap.put("O96826Y", cow7);
        CowTreeMap.put("O34799Y", cow8);
        CowTreeMap.put("O52012Y", cow9);
        CowTreeMap.put("O83391Y", cow10);
        return CowTreeMap;
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

    public PriorityQueue<Cow> priorityQueue(Cow cow1, Cow cow2, Cow cow3, Cow cow4, Cow cow5, Cow cow6, Cow cow7, Cow cow8,
                                    Cow cow9, Cow cow10)
    {
        PriorityQueue<Cow> priorityQueue= new PriorityQueue<>();
        priorityQueue.add(cow1);
        priorityQueue.add(cow2);
        priorityQueue.add(cow3);
        priorityQueue.add(cow4);
        priorityQueue.add(cow5);

        priorityQueue.add(cow6);
        priorityQueue.add(cow7);
        priorityQueue.add(cow8);
        priorityQueue.add(cow9);
        priorityQueue.add(cow10);
        return priorityQueue;
    }



}
