package Bank_Project;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class BankService {
    private Map<Integer, Customer> customerMap = new HashMap<>();
    private int nextAccountNumber = 1001;
    private final String DATA_FILE = "bankdata.ser";

    public BankService() {
        loadFromFile();
    }

    public void addCustomer(String name, double balance, String password) {
        Customer customer = new Customer(nextAccountNumber, name, balance, password);
        customerMap.put(nextAccountNumber, customer);
        System.out.println("Customer added. Account Number: " + nextAccountNumber);
        System.out.println("Waiting for Admin Approval...");
        nextAccountNumber++;
        saveToFile();
    }

    public void printAllCustomers() {
        if (customerMap.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer customer : customerMap.values()) {
            customer.display();
            System.out.println("----------------------");
        }
    }

    public void approveCustomer(int accountNumber) {
        Customer customer = customerMap.get(accountNumber);
        if (customer != null && !customer.isApproved()) {
            customer.setApproved(true);
            System.out.println("Customer approved successfully.");
            saveToFile();
        } else {
            System.out.println("Customer not found or already approved.");
        }
    }

    public void updateCustomerDetails(Customer customer, String newName, String newPassword) {
        customer.setAccountHolder(newName);
        customer.setPassword(newPassword);
        System.out.println("Details updated successfully.");
        saveToFile();
    }

    public void deleteCustomer(int accountNumber) {
        if (customerMap.remove(accountNumber) != null) {
            System.out.println("Customer deleted successfully.");
            saveToFile();
        } else {
            System.out.println("Customer not found.");
        }
    }

    public Customer loginCustomer(int accountNumber, String password) {
        Customer customer = customerMap.get(accountNumber);
        if (customer != null && customer.getPassword().equals(password)) {
            if (customer.isApproved()) {
                return customer;
            } else {
                System.out.println("Account not approved yet. Contact Admin.");
            }
        }
        return null;
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(customerMap);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            customerMap = (Map<Integer, Customer>) ois.readObject();
            if (!customerMap.isEmpty()) {
                nextAccountNumber = Collections.max(customerMap.keySet()) + 1;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing data found. Starting fresh.");
        }
    }
}
