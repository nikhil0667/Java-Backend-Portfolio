package ThreadSyn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "Outer is running");
            innerMethod();
        }catch (Exception e) {
            System.out.println("Outer"+e.getMessage());
        }

        finally {
            lock.unlock();

        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "Inner is running");
        } catch (Exception e) {
            System.out.println("Inner"+e.getMessage());
        } finally {
            lock.unlock();
        }

    }
    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
