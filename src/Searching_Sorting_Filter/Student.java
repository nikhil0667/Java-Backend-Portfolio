package Searching_Sorting_Filter;

public class Student {
    static int no = 1;
    private int id, m1, m2, m3, totalMark;
    private String name, city, grade;
    private double pr;

    public Student(String name, int m1, int m2, int m3, String city) {
        this.id = no;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.city = city;

        this.totalMark = m1 + m2 + m3;
        this.pr = totalMark / 3.0;

        if (pr >= 75) grade = "A";
        else if (pr >= 60) grade = "B";
        else if (pr >= 40) grade = "C";
        else grade = "D";


        no++;
    }

    public String getGrade() {
        return grade;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-5d %-5d %-5d %-7d %-10s %-6s %-5.2f",
                id, name, m1, m2, m3, totalMark, city, grade, pr);
    }

}
