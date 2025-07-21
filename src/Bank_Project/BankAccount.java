package Bank_Project;


import java.util.Scanner;
public class BankAccount {
    static Scanner sc = new Scanner(System.in);
    static BankService bankService = new BankService();

    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println("Welcome to Bank Account");
        System.out.println("=========================");

        while (true) {
            System.out.println("\n1. Admin \n2. Customer \n3. Exit");
            System.out.print("Enter Your Choice: ");
            int roleChoice = sc.nextInt();

            switch (roleChoice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    customerLogin();
                    break;
                case 3:
                    System.out.println("Thank you for using our bank system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void adminLogin() {
        AdminService adminService = new AdminService();
        System.out.print("Enter Admin Name: ");
        String name = sc.next();
        System.out.print("Enter Admin Password: ");
        String password = sc.next();

        if (adminService.login(name, password)) {
            System.out.println("Admin Login Successful!");
            adminMenu();
        } else {
            System.out.println("Admin Login Failed!");
        }
    }

    public static void adminMenu() {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Approve Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    System.out.print("Set Customer Password: ");
                    String password = sc.next();
                    bankService.addCustomer(name, balance, password);
                    break;
                case 2:
                    bankService.printAllCustomers();
                    break;
                case 3:
                    System.out.print("Enter Account Number to Approve: ");
                    int accNumApprove = sc.nextInt();
                    bankService.approveCustomer(accNumApprove);
                    break;
                case 4:
                    System.out.print("Enter Account Number to Delete: ");
                    int accNumDelete = sc.nextInt();
                    bankService.deleteCustomer(accNumDelete);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void customerLogin() {
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        System.out.print("Enter Password: ");
        String password = sc.next();

        Customer customer = bankService.loginCustomer(accNum, password);
        if (customer != null) {
            System.out.println("Customer Login Successful!");
            customerMenu(customer);
        } else {
            System.out.println("Login Failed.");
        }
    }

    public static void customerMenu(Customer customer) {
        while (true) {
            System.out.println("\n===== Customer Menu =====");
            System.out.println("1. View Profile");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Update Name/Password");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    customer.display();
                    break;
                case 2:
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = sc.nextDouble();
                    customer.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    customer.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter New Name: ");
                    String newName = sc.next();
                    System.out.print("Enter New Password: ");
                    String newPassword = sc.next();
                    bankService.updateCustomerDetails(customer, newName, newPassword);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}