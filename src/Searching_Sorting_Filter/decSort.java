package Searching_Sorting_Filter;

import java.util.Comparator;

public class decSort implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getName().compareTo(o1.getName());
    }


}
