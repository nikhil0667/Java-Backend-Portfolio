package Bank_Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Customer implements Serializable {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private String password;
    private boolean isApproved;
    private List<Transaction> transactions = new ArrayList<>();

    public Customer(int accountNumber, String accountHolder, double balance, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.password = password;
        this.isApproved = false;
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

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}
