package ThreadSyn;

import java.util.concurrent.locks.ReentrantLock;

public class unfairLock {
    private final ReentrantLock unfairLock = new ReentrantLock(true);

    public void accessResource() {
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is acquiring lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " is released lock");
            unfairLock.unlock();
               }
    }

    public static void main(String[] args) {
        unfairLock lock = new unfairLock();
        Runnable runnable = lock::accessResource;
        Thread t1 = new Thread(runnable,"Thread - 1");
        Thread t2 = new Thread(runnable,"Thread - 2");
        Thread t3 = new Thread(runnable,"Thread - 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
