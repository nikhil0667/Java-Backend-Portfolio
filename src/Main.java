import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<StudentModel> list = new ArrayList<>();
        HashSet<StudentModel> set = new HashSet<>();
        list.add(new StudentModel(1, 20));
        list.add(new StudentModel(2, 21));
        list.add(new StudentModel(1, 20));
        list.add(new StudentModel(2, 21));
        System.out.println("List Item");
        for (StudentModel s : list) {
            System.out.println(s);
        }

        set.add(new StudentModel(1, 20));
        set.add(new StudentModel(2, 21));
        set.add(new StudentModel(1, 20));
        set.add(new StudentModel(2, 21));

        System.out.println("Set Item");
        for (StudentModel s : set) {
            System.out.println(s);
        }


        TestString();
    }

    public static void TestString() {
        String s = "Hello";
        String s1 = "Hello";
        String s2 = new String("Hello");
        String s3 = new String("Hella");
        //  System.out.println(s == s1);
        System.out.println(s2.equals(s3));
        System.out.println(s2.equals(s3));
        System.out.println(true);
        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        boolean equals = s.intern().equals(s1.intern());
        System.out.println(equals);
        System.out.println(s.intern().hashCode());
        System.out.println(s1.intern().hashCode());
        System.out.println(equals);

    }

}

