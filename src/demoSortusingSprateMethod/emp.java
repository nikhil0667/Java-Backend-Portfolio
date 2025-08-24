package demoSortusingSprateMethod;

public class emp implements Comparable<emp>{

    private String name;

    private String city;

    public emp(String name ,String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity()
    {
        return city;
    }

    @Override
    public String toString() {
        return "emp{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int compareTo(emp o) {
        return this.name.compareTo(o.name);
    }
}
