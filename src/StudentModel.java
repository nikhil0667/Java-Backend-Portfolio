public class StudentModel {
    int id;
    int age;

    public StudentModel(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public String toString() {
        return "Id: " + id + "\nAge: " + age + "\n";
    }
}
