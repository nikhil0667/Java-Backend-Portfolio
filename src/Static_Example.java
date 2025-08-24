public class Static_Example {
    Static_Example() {
        System.out.println("Constructor");
    }

    int a = 10;

    static void m1() {
        System.out.println("m1");
    }

    static void m2() {
        System.out.println("m2");
    }

    public static void main(String[] args) {
        Static_Example.m1();
        Static_Example staticExample = new Static_Example();
        staticExample.a = 100;
System.out.println(Day.SUNDAY.name());
        System.out.println("a = " + staticExample.a);
    }
}
