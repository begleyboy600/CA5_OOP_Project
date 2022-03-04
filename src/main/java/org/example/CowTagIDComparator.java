package org.example;

import java.util.Comparator;

public class CowTagIDComparator
        implements Comparator<Cow>
{
    private SortType sortType;

    public CowTagIDComparator(SortType sortType)
    {
        this.sortType = sortType;
    }

    @Override
    public int compare(Cow c1, Cow c2)
    {
        int direction = sortType.getValue();
        return direction * (c1.getTag_id() - c2.getTag_id());
    }
}
