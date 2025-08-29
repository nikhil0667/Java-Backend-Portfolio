package Bank_Project;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Scanner;

public class BankAccount {
    private BankService bankService = new BankService();
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankAccount().createLoginWindow());
    }

    private void createLoginWindow() {
        frame = new JFrame("🏦 Modern Bank Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(new EmptyBorder(20, 50, 20, 50));

        JLabel title = new JLabel("Welcome to Modern Bank", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(0, 102, 204));

        String[] roles = {"Admin", "Customer"};
        JComboBox<String> roleCombo = new JComboBox<>(roles);
        JTextField usernameField = new JTextField();
        usernameField.setBorder(BorderFactory.createTitledBorder("Account# / Admin Name"));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton loginButton = new JButton("🔓 Login");
        styleButton(loginButton);
        loginButton.addActionListener(e -> {
            String role = (String) roleCombo.getSelectedItem();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if ("Admin".equals(role)) {
                if ("admin".equals(username) && "1234".equals(password)) {
                    frame.dispose();
                    showAdminDashboard();
                } else {
                    showMessage("❌ Invalid Admin Credentials");
                }
            } else {
                try {
                    int accNum = Integer.parseInt(username);
                    Customer customer = bankService.loginCustomer(accNum, password);
                    frame.dispose();
                    showCustomerDashboard(customer);
                } catch (NumberFormatException | IllegalStateException ex) {
                    showMessage("❌ " + ex.getMessage());
                }
            }
        });

        panel.add(title);
        panel.add(roleCombo);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(loginButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void showAdminDashboard() {
        JFrame adminFrame = new JFrame("👨‍💼 Admin Dashboard");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(700, 500);
        adminFrame.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("📋 View Customers", createViewCustomersPanel());
        tabs.addTab("✅ Approve Customers", createApprovePanel());
        tabs.addTab("➕ Add Customer", createAddCustomerPanel());
        tabs.addTab("🔍 Search Customer", createSearchPanel());
        adminFrame.add(tabs);

        adminFrame.setVisible(true);
    }

    private JPanel createViewCustomersPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel(new String[]{"Account#", "Name", "Balance", "Approved"}, 0);
        JTable table = new JTable(model);
        refreshCustomerTable(model);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createApprovePanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        JTextField accField = new JTextField();
        accField.setBorder(BorderFactory.createTitledBorder("Enter Account Number"));
        JButton approveBtn = new JButton("✔ Approve");
        styleButton(approveBtn);
        approveBtn.addActionListener(e -> {
            int accNum = Integer.parseInt(accField.getText());
            bankService.approveCustomer(accNum);
            showMessage("✅ Customer Approved");
        });
        panel.add(accField);
        panel.add(approveBtn);
        return panel;
    }

    private JPanel createAddCustomerPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        JTextField nameField = new JTextField();
        nameField.setBorder(BorderFactory.createTitledBorder("Customer Name"));
        JTextField balanceField = new JTextField();
        balanceField.setBorder(BorderFactory.createTitledBorder("Initial Balance"));
        JPasswordField pwdField = new JPasswordField();
        pwdField.setBorder(BorderFactory.createTitledBorder("Password"));
        JButton addBtn = new JButton("➕ Add");
        styleButton(addBtn);
        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            double balance = Double.parseDouble(balanceField.getText());
            String pass = new String(pwdField.getPassword());
            bankService.addCustomer(name, balance, pass);
            showMessage("✅ Customer Added (Pending Approval)");
        });
        panel.add(nameField);
        panel.add(balanceField);
        panel.add(pwdField);
        panel.add(addBtn);
        return panel;
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        JTextField searchField = new JTextField();
        searchField.setBorder(BorderFactory.createTitledBorder("Enter Account Number"));
        JButton searchBtn = new JButton("🔍 Search");
        styleButton(searchBtn);
        searchBtn.addActionListener(e -> {
            int accNum = Integer.parseInt(searchField.getText());
            Customer c = bankService.searchCustomer(accNum);
            if (c != null) {
                String info = String.format("Account#: %d\nName: %s\nBalance: %.2f\nApproved: %b", c.getAccountNumber(), c.getAccountHolder(), c.getBalance(), c.isApproved());
                showMessage(info);
            } else {
                showMessage("❌ Customer Not Found");
            }
        });
        panel.add(searchField);
        panel.add(searchBtn);
        return panel;
    }

    private void showCustomerDashboard(Customer customer) {
        JFrame custFrame = new JFrame("👤 Customer Dashboard - " + customer.getAccountHolder());
        custFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        custFrame.setSize(600, 500);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("📋 Profile", createProfilePanel(customer));
        tabs.addTab("💵 Deposit", createDepositPanel(customer));
        tabs.addTab("🏧 Withdraw", createWithdrawPanel(customer));
        tabs.addTab("✏ Update Profile", createUpdatePanel(customer));
        tabs.addTab("🕑 Transaction History", createTransactionPanel(customer));

        custFrame.add(tabs);
        custFrame.setVisible(true);
    }

    private JPanel createProfilePanel(Customer c) {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(new JLabel("Account#: " + c.getAccountNumber()));
        panel.add(new JLabel("Name: " + c.getAccountHolder()));
        panel.add(new JLabel("Balance: ₹" + c.getBalance()));
        panel.add(new JLabel("Approved: " + (c.isApproved() ? "Yes" : "No")));
        return panel;
    }

    private JPanel createDepositPanel(Customer c) {
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        JTextField amtField = new JTextField();
        amtField.setBorder(BorderFactory.createTitledBorder("Enter Amount"));
        JButton depBtn = new JButton("💵 Deposit");
        styleButton(depBtn);
        depBtn.addActionListener(e -> {
            double amt = Double.parseDouble(amtField.getText());
            c.deposit(amt);
            showMessage("✅ Amount Deposited");
        });
        panel.add(amtField);
        panel.add(depBtn);
        return panel;
    }

    private JPanel createWithdrawPanel(Customer c) {
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        JTextField amtField = new JTextField();
        amtField.setBorder(BorderFactory.createTitledBorder("Enter Amount"));
        JButton withBtn = new JButton("🏧 Withdraw");
        styleButton(withBtn);
        withBtn.addActionListener(e -> {
            try {
                double amt = Double.parseDouble(amtField.getText());
                c.withdraw(amt);
                showMessage("✅ Amount Withdrawn");
            } catch (IllegalArgumentException ex) {
                showMessage("❌ " + ex.getMessage());
            }
        });
        panel.add(amtField);
        panel.add(withBtn);
        return panel;
    }

    private JPanel createUpdatePanel(Customer c) {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        JTextField nameField = new JTextField();
        nameField.setBorder(BorderFactory.createTitledBorder("New Name"));
        JPasswordField pwdField = new JPasswordField();
        pwdField.setBorder(BorderFactory.createTitledBorder("New Password"));
        JButton updateBtn = new JButton("✏ Update");
        styleButton(updateBtn);
        updateBtn.addActionListener(e -> {
            c.setAccountHolder(nameField.getText());
            c.setPassword(new String(pwdField.getPassword()));
            showMessage("✅ Profile Updated");
        });
        panel.add(nameField);
        panel.add(pwdField);
        panel.add(updateBtn);
        return panel;
    }

    private JPanel createTransactionPanel(Customer c) {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel(new String[]{"Type", "Amount", "Date"}, 0);
        JTable table = new JTable(model);
        for (Transaction t : c.getTransactions()) {
            model.addRow(new Object[]{t.getType(), "₹" + t.getAmount(), t.getDate()});
        }
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private void refreshCustomerTable(DefaultTableModel model) {
        model.setRowCount(0);
        for (Customer c : bankService.getAllCustomers()) {
            model.addRow(new Object[]{c.getAccountNumber(), c.getAccountHolder(), c.getBalance(), c.isApproved() ? "Yes" : "No"});
        }
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(frame, msg);
    }

    private void styleButton(JButton btn) {
        btn.setBackground(new Color(0, 153, 204));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 153), 2));
    }


}

//    static Scanner sc = new Scanner(System.in);
//    static BankService bankService = new BankService();
//
//    public static void main(String[] args) {
//        System.out.println("=========================");
//        System.out.println("Welcome to Bank Account");
//        System.out.println("=========================");
//
//        while (true) {
//            System.out.println("\n1. Admin \n2. Customer \n3. Exit");
//            System.out.print("Enter Your Choice: ");
//            int roleChoice = sc.nextInt();
//
//            switch (roleChoice) {
//                case 1:
//                    adminLogin();
//                    break;
//                case 2:
//                    customerLogin();
//                    break;
//                case 3:
//                    System.out.println("Thank you for using our bank system.");
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Try again.");
//            }
//        }
//    }
//
//    public static void adminLogin() {
//        AdminService adminService = new AdminService();
//        System.out.print("Enter Admin Name: ");
//        String name = sc.next();
//        System.out.print("Enter Admin Password: ");
//        String password = sc.next();
//
//        if (adminService.login(name, password)) {
//            System.out.println("Admin Login Successful!");
//            adminMenu();
//        } else {
//            System.out.println("Admin Login Failed!");
//        }
//    }
//
//    public static void adminMenu() {
//        while (true) {
//            System.out.println("\n===== Admin Menu =====");
//            System.out.println("1. Add Customer");
//            System.out.println("2. View All Customers");
//            System.out.println("3. Approve Customer");
//            System.out.println("4. Delete Customer");
//            System.out.println("5. Back to Main Menu");
//            System.out.print("Enter your choice: ");
//            int choice = sc.nextInt();
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter Customer Name: ");
//                    String name = sc.next();
//                    System.out.print("Enter Initial Balance: ");
//                    double balance = sc.nextDouble();
//                    System.out.print("Set Customer Password: ");
//                    String password = sc.next();
//                    bankService.addCustomer(name, balance, password);
//                    break;
//                case 2:
//                    bankService.printAllCustomers();
//                    break;
//                case 3:
//                    System.out.print("Enter Account Number to Approve: ");
//                    int accNumApprove = sc.nextInt();
//                    bankService.approveCustomer(accNumApprove);
//                    break;
//                case 4:
//                    System.out.print("Enter Account Number to Delete: ");
//                    int accNumDelete = sc.nextInt();
//                    bankService.deleteCustomer(accNumDelete);
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
//
//    public static void customerLogin() {
//        System.out.print("Enter Account Number: ");
//        int accNum = sc.nextInt();
//        System.out.print("Enter Password: ");
//        String password = sc.next();
//
//        Customer customer = bankService.loginCustomer(accNum, password);
//        if (customer != null) {
//            System.out.println("Customer Login Successful!");
//            customerMenu(customer);
//        } else {
//            System.out.println("Login Failed.");
//        }
//    }
//
//    public static void customerMenu(Customer customer) {
//        while (true) {
//            System.out.println("\n===== Customer Menu =====");
//            System.out.println("1. View Profile");
//            System.out.println("2. Deposit");
//            System.out.println("3. Withdraw");
//            System.out.println("4. Update Name/Password");
//            System.out.println("5. Back to Main Menu");
//            System.out.print("Enter your choice: ");
//            int choice = sc.nextInt();
//
//            switch (choice) {
//                case 1:
//                    customer.display();
//                    break;
//                case 2:
//                    System.out.print("Enter Amount to Deposit: ");
//                    double depositAmount = sc.nextDouble();
//                    customer.deposit(depositAmount);
//                    break;
//                case 3:
//                    System.out.print("Enter Amount to Withdraw: ");
//                    double withdrawAmount = sc.nextDouble();
//                    customer.withdraw(withdrawAmount);
//                    break;
//                case 4:
//                    System.out.print("Enter New Name: ");
//                    String newName = sc.next();
//                    System.out.print("Enter New Password: ");
//                    String newPassword = sc.next();
//                    bankService.updateCustomerDetails(customer, newName, newPassword);
//                    break;
//                case 5:
//                    return;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
//}