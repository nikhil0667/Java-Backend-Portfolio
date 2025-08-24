package demoSortusingSprateMethod;

import java.util.Comparator;

public class sortedData implements Comparator<emp> {
    @Override
    public int compare(emp o1, emp o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
