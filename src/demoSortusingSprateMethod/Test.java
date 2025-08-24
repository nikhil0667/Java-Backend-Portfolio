package demoSortusingSprateMethod;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<student> students  = new ArrayList<>();



        // Some sample names and cities
        String[] names = {"Aman", "Neha", "Ravi", "Priya", "Sohan", "Zara", "Nikhil", "Isha", "Rohan", "Meera", "Arjun", "Tina", "Deep", "Kiran", "Simran"};
        String[] cities = {"Delhi", "Mumbai", "Pune", "Chennai", "Kolkata", "Jaipur", "Hyderabad"};

        Random random = new Random();

        // Insert 15 random students
        for (int i = 0; i < 15; i++) {
            String name = names[i % names.length]; // pick from array
            String city = cities[random.nextInt(cities.length)];
            int mobile = 900000000 + random.nextInt(10000000); // random 10 digit
            students.add(new student(name, city, mobile));
        }

        students.sort(new sortDataAll());
        System.out.println(students);

        SortedMap<Integer,String> map = new TreeMap<>((x,y)-> x-y);

        //
        SortedMap<String,String> stringStringSortedMap = new TreeMap<>((x,y) -> y.compareTo(x));

        stringStringSortedMap.put("Pradipsinh","Botad");

        stringStringSortedMap.put("Nikhil","surat");

        System.out.println(stringStringSortedMap);



    }
}
