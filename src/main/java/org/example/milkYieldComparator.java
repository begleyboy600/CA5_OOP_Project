package org.example;

import java.util.Comparator;

public class milkYieldComparator
        implements Comparator<Cow> {
    private SortType sortType;

    public milkYieldComparator(SortType sortType) {
        this.sortType = sortType;
    }

    @Override
    public int compare(Cow c1, Cow c2) {
        int direction = sortType.getValue();
        return direction * (c1.getMilkYields() - c2.getMilkYields());
    }
}

