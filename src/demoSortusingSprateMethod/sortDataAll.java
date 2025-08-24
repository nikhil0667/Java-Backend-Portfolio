package demoSortusingSprateMethod;

import java.util.Comparator;

public class sortDataAll implements Comparator<student> {

    @Override
    public int compare(student o1, student o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
