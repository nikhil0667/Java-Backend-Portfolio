package ApnaCollege.Linkdlist;

import java.util.LinkedList;
import java.util.stream.Collectors;

class LL {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        LinkedList<Integer> lis2 = new LinkedList<>();
        for (int i = 0; i <= 10; i++)
            list.add(i);

        System.out.println(list);
        list.removeIf(n -> n %2 != 0);
        list.forEach(System.out::println);
list.sort((a,b) -> a.compareTo(b));
    }

}
