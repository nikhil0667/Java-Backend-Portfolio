package Bank_Project;

import java.io.Serializable;

class Customer implements Serializable {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private String password;

    private boolean isApproved;

    public Customer(int accountNumber, String accountHolder, double balance, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public String getPassword() {
        return password;
    }

    public void display() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Approved: " + (isApproved ? "Yes" : "No"));

    }
}
