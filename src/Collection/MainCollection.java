package Collection;

public class MainCollection {
    public static void main(String[] args) {
        LindklistDemo lindklistDemo = new LindklistDemo();
        lindklistDemo.add(10);
        lindklistDemo.add(20);
        lindklistDemo.add(30);
        lindklistDemo.add(40);
        lindklistDemo.add(50);
        lindklistDemo.display();
        lindklistDemo.remove(20);
       System.out.println("After remove");
        lindklistDemo.display();
        System.out.println("First and last");
        lindklistDemo.getLast();
        lindklistDemo.getFirst();
        lindklistDemo.removeFirst();
        lindklistDemo.removeLast();
        lindklistDemo.removeIf();
        System.out.println("After remove first and last");
        lindklistDemo.display();
    }
}
