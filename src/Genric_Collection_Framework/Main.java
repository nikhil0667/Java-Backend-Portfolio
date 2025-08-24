package Genric_Collection_Framework;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>("Hello");
        System.out.println(box.getT());

        BoxDemo<String,Integer> integerBoxDemo = new BoxDemo<>("Hello",10);
        System.out.println(integerBoxDemo.getKey());
        System.out.println(integerBoxDemo.getValue());
    }
}
