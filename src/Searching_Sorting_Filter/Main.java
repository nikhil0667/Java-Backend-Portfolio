package Searching_Sorting_Filter;

import java.text.Collator;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        ArrayList<Student> students = new ArrayList<Student>();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\nPress 1. AddData \nPress 2. SearchData \nPress 3.Sort(Asc/Desc) \nPress 4. Filter  \nPress 5. Display \nPress 6. Exit");
            System.out.print("\n\nEnter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    AddData(students);
                    break;
                }
                case 2 -> {
                    SearchData(students);

                    break;
                }
                case 3 -> {
                    SortData(students);
                    break;
                }
                case 4 -> {
                    FilterData(students);
                    break;
                }
                case 5 -> {
                    Display(students, "All Data Display");
                }
                case 6 -> {
                    System.out.print("Are you sure to exit Yes or No : ");
                    String s = input.next().trim().toLowerCase();
//                    char n = s.charAt(0);
//                    char n = input.nextLine().toLowerCase().trim().charAt(0);

                    if (s.startsWith("y")) {
                        System.out.println("Thanks for using our program");
                        System.exit(0);
                    }
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void SortData(ArrayList<Student> students) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Ascending order: ");
        boolean ascending = input.nextBoolean();
        if (ascending) {

            students.sort((x, y) -> x.getName().compareTo(y.getName()));
            Display(students, "Sorted Ascending");

        } else {
            students.sort((x, y) -> y.getName().compareTo(x.getName()));
            Display(students, "Sorted Descending");


        }
    }

    private static void FilterData(ArrayList<Student> students) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter grade to filter: ");
        String grade = input.next();

        students.stream()
                .filter(s -> s.getGrade().equalsIgnoreCase(grade.toLowerCase()))
                .forEach(System.out::println);

    }

    private static void SearchData(ArrayList<Student> students) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Search");
        String n = input.next();
        students.stream().filter(s -> s.getName().toLowerCase().contains(n.toLowerCase())).forEach(System.out::println);


    }

    public static void AddData(ArrayList<Student> students) {
        String[] names = {"Nikhil", "Raj", "Amit", "Kiran", "Pooja", "Ravi", "Sneha", "Manoj", "Neha", "Sanjay", "Anita", "Mehul", "Rohit", "Payal", "Deepak"};
        String[] cities = {"Surat", "Rajkot", "Ahmedabad", "Vadodara", "Bhavnagar"};

        // Add 15 student records
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            String name = names[i % names.length];
            String city = cities[random.nextInt(cities.length)];
            int m1 = random.nextInt(101);
            int m2 = random.nextInt(101);
            int m3 = random.nextInt(101);
            students.add(new Student(name, m1, m2, m3, city));
        }
    }

    public static void Display(ArrayList<Student> students, String name) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("---------------------------- " + name + "----------------------------");
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("\n\n--------------------------------------------------------------------------");


        System.out.printf("%-5s %-10s %-5s %-5s %-5s %-7s %-10s %-6s %-5s%n", "ID", "Name", "M1", "M2", "M3", "Total", "City", "Grade", "PR");
        System.out.println("--------------------------------------------------------------------------");

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
