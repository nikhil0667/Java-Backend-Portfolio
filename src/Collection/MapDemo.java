package Collection;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        mapDemo();

    }

    public static void mapDemo() {
//        Map<Integer, String> map = new TreeMap<>();// Default sort formate
//Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder()); // Descading Formate
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(40, "Programming");
        map.put(70, "All");
        map.put(80, "Tutorial");
        map.put(90, "All");
        map.put(10, "Hello");
        map.put(50, "Language");
        map.put(60, "Concept");
        map.put(20, "World");
        map.put(30, "Java");
        map.put(100, "Concept");

        map.entrySet().stream().sorted((x, y) -> x.getValue().compareTo(y.getValue())).forEach(System.out::println);
//map.entrySet().stream().sorted(new commonsort()).forEach(System.out::println);
//map.entrySet().stream().sorted(new commonsort().reversed())

    }
}
