public class Abstract_Class implements Animal_interface {
    public static void main(String[] args) {
        Abstract_Class obj = new Abstract_Class();
        obj.eat();
        obj.sleep();
    }

    @Override
    public void eat() {
        System.out.println("Eating");
    }

    @Override
    public void sleep() {

        System.out.println("Sleeping");
    }
}
