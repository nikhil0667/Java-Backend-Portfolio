package ThreadExample;

class MyThread extends Thread {
    private String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(500); // Simulate some work
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
        }
    }
}

public class JoinExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");

        t2.setPriority(Thread.MAX_PRIORITY);
        Thread.yield();
        t1.start();

t2.start();
t3.start();


//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        t2.start();
//        try {
//            t2.join();
//        }  catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        t3.start();
//        try {
//             t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("All threads finished. Main thread exiting.");
    }
}

