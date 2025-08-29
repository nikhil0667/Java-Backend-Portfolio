package ThreadSyn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count = 0;  // corrected typo
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    // Writer method: increments the counter
    public void increment() {
        writeLock.lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + ": incremented to " + count);
        } finally {
            writeLock.unlock();
        }
    }

    // Reader method: returns the current count
    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
//        ReadWriteCounter counter = new ReadWriteCounter();
//
//        // Writer Runnable
//        Runnable writeTask = () -> {
//            for (int i = 0; i < 10; i++) {
//                counter.increment();
//                try {
//                    Thread.sleep(500); // simulate some processing time
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        };
//
//        // Reader Runnable
//        Runnable readTask = () -> {
//            for (int i = 0; i < 10; i++) {
//                int value = counter.getCount();
//                System.out.println(Thread.currentThread().getName() + ": reads count = " + value);
//                try {
//                    Thread.sleep(300); // simulate read delay
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        };
//
//        // Creating threads
//        Thread writer = new Thread(writeTask, "Writer-1");
//        Thread reader1 = new Thread(readTask, "Reader-1");
//        Thread reader2 = new Thread(readTask, "Reader-2");
//
//        // Start threads
//        writer.start();
//        reader1.start();
//        reader2.start();
//
//        // Wait for threads to finish
//        try {
//            writer.join();
//            reader1.join();
//            reader2.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        System.out.println("Final Count: " + counter.getCount());

        Thread t = new Thread(()->System.out.println(Thread.currentThread().getName()));

    }
}







