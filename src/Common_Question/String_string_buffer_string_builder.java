/**
 * The class demonstrates the use of StringBuilder, StringBuffer, and Thread in Java to manipulate strings concurrently.
 */
package Common_Question;

public class String_string_buffer_string_builder {

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("a");
        for (int i = 0; i <= 3; i++) {

        }
        System.out.println(s1);
        System.out.println(s1.length());

        StringBuffer sb = new StringBuffer();
        Task t1 = new Task(sb);
        Task t2 = new Task(sb);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            System.out.println("Final length " + sb.length(

            ));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Task extends Thread {
    private StringBuffer sb;

    public Task(StringBuffer sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }
    }
}