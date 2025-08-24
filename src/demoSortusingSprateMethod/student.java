package demoSortusingSprateMethod;

public class student {
    private String name;
    private String city;
    private int mobNo;

    public student(String name, String city, int mobNo) {
        this.name = name;
        this.city = city;
        this.mobNo = mobNo;
    }

    public String getName() {
        return name;
    }

    public int getMobNo() {
        return mobNo;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "\nstudent{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", mobNo=" + mobNo +
                '}';
    }

}
