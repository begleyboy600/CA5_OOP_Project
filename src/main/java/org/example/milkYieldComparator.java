package org.example;

import org.example.DTOs.Cow;

import java.util.Comparator;

public class milkYieldComparator
        implements Comparator<Cow> {
    @Override
    public int compare(Cow cow1, Cow cow2) {
        return cow2.getMilkYields() - cow1.getMilkYields();
    }
}

