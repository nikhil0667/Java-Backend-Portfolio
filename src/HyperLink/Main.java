package HyperLink;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Raj", 39, 23));
        studentList.add(new Student(2, "Ramesh", 38, 24));
        studentList.add(new Student(3, "Nikhil", 100, 74));
        studentList.add(new Student(4, "Abhi", 78, 98));

        studentList.sort(Student.sortByNameAsc);
        System.out.println("-------------------------------------------------");
        System.out.println("Student List  Age ASC");
        System.out.println("-------------------------------------------------");
        System.out.printf("\n%-10s %-15s %-10s %-5s%n", "ID", "Name", "Mark", "Age");
        System.out.println("-------------------------------------------------");
        for (Student s : studentList) {
            System.out.println(s);
        }
        studentList.sort(Student.sortByNameDesc);
        System.out.println("-------------------------------------------------");
        System.out.println("Student List Age  DSC");
        System.out.println("-------------------------------------------------");
        System.out.printf("\n%-10s %-15s %-10s %-5s%n", "ID", "Name", "Mark", "Age");
        System.out.println("-------------------------------------------------");
        for (Student s : studentList) {
            System.out.println(s);
        }
// Search
        System.out.println("-------------------------------------------------");
        studentList.stream().filter(student -> student.getName().toLowerCase().contains("ikhi".toLowerCase())).forEach(System.out::println);
        // Filter
        System.out.println("-------------------------------------------------");
        studentList.stream().filter(student -> student.getMark() >= 39).forEach(System.out::println);


        List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 2, 8, 3, 5, 6, 7, 1, 3, 4, 6));
        list.sort((x, y) -> x - y);

        //
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set);
        for (int a : list) {
            if (!set.add(a)) System.out.println("Duplicate" + a);
        }


        String sentence = "hello world hello java";
        String[] words = sentence.split(" ");
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println(freq);


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : list) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        System.out.println(map);


        // PELIDROM NUMBER

        int n = 121, temp = n, reverse = 0;
        while (temp != 0) {
            int digit = temp %10;
            reverse = reverse * 10 +digit;
            temp /= 10;
        }
        if (n == reverse) System.out.println("Palindrome Number");
        else System.out.println("Not Palindrome Number");

        // Armastorng Number
        int num = 153,tem = num,sum = 0;
        while (tem != 0) {
            int digit = tem %10;
            sum = sum + digit*digit*digit;
            tem /= 10;
        }
            System.out.println(num==sum?"Armstrong":"Not Armstrong");

System.out.print(factiorial(5));
System.out.print(fibnocisearia(10));

    }
    static  int factiorial(int n){
        if(n==0)return 1;
        return n*factiorial(n-1);
    }
    static int fibnocisearia(int n){
        int a = 0;
        int b= 1;
        for(int i = 0;i<n;i++){

            System.out.print(a+" ");
            int c = a+b;
            a=b;
            b=c;
        }
        return a;

    }

}
