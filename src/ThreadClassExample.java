import java.util.Arrays;
import java.util.stream.Collectors;

public class ThreadClassExample extends Thread {
    @Override
    public void run() {

    }
public String printThreadInfo(String threadName) {
        return threadName;
}
public String printThreadInfo() {
        return Thread.currentThread().getName();
}
    public static void main(String[] args) {
        ThreadClassExample t1 = new ThreadClassExample();
 Animal_interface a = new Animal_interface() {
     @Override
     public void eat() {

     }

     @Override
     public void sleep() {
         System.out.println("Sleeping");
     }
 };    t1.start();
        System.out.println("Main thread is running");

        try {
            Thread.sleep(100);
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
