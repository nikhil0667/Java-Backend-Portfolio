package HyperLink;

import java.util.Comparator;

public class Student  {
    int Student_id;
    String name;
    int mark;
    int age;

    public Student(int Student_id, String name, int mark, int age) {
        this.Student_id = Student_id;
        this.name = name;
        this.mark = mark;
        this.age = age;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s %-5s",
                Student_id, name, mark, age);
    }

    public static Comparator<Student> sortByNameAsc = Comparator.comparing(Student::getName);
    public static Comparator<Student> sortByNameDesc = (s1, s2) -> s2.getName().compareTo(s1.getName());
    public static Comparator<Student> sortByAgeAsc = Comparator.comparingInt(Student::getAge);
    public static Comparator<Student> sortByAgeDesc = (s1, s2) -> s2.getAge() - s1.getAge();
    public static Comparator<Student> sortByMarkAsc = (s1, s2) -> s1.getMark() - s2.getMark();
    public static Comparator<Student> sortByMarkDesc = (s1, s2) -> s2.getMark() - s1.getMark();
    public static Comparator<Student> sortByIdAsc = (s1, s2) -> s1.getStudent_id() - s2.getStudent_id();
    public static Comparator<Student> sortByIdDesc = (s1, s2) -> s2.getStudent_id() - s1.getStudent_id();


}


