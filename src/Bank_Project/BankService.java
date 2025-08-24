package Bank_Project;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
class BankService {
    private Map<Integer, Customer> customerMap = new HashMap<>();
    private int nextAccountNumber = 1001;
    private final String DATA_FILE = "bankdata.ser";

    public BankService() { loadFromFile(); }

    public void addCustomer(String name, double balance, String password) {
        Customer customer = new Customer(nextAccountNumber, name, balance, password);
        customerMap.put(nextAccountNumber, customer);
        nextAccountNumber++;
        saveToFile();
    }

    public Collection<Customer> getAllCustomers() {
        return customerMap.values();
    }

    public Customer loginCustomer(int accountNumber, String password) {
        Customer customer = customerMap.get(accountNumber);
        if (customer != null && customer.getPassword().equals(password)) {
            if (customer.isApproved()) return customer;
            else throw new IllegalStateException("Account not approved yet.");
        }
        return null;
    }

    public void approveCustomer(int accountNumber) {
        Customer customer = customerMap.get(accountNumber);
        if (customer != null) {
            customer.setApproved(true);
            saveToFile();
        }
    }

    public void deleteCustomer(int accountNumber) {
        customerMap.remove(accountNumber);
        saveToFile();
    }

    public Customer searchCustomer(int accountNumber) {
        return customerMap.get(accountNumber);
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(customerMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            customerMap = (Map<Integer, Customer>) ois.readObject();
            if (!customerMap.isEmpty())
                nextAccountNumber = Collections.max(customerMap.keySet()) + 1;
        } catch (Exception ignored) { }
    }
}
