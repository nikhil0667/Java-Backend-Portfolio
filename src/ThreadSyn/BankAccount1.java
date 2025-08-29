package ThreadSyn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount1 {
    private int balance = 220;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + ": Trying to withdraw " + amount);


        try {
            if (lock.tryLock(20000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": Withdrawal in process...");
                        Thread.sleep(1000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() +
                                ": Withdrawal done. Balance left = " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ": Insufficient balance!");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Colud not acquire the lock will try later");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

