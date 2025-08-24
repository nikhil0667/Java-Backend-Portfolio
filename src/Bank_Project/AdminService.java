package Bank_Project;

class AdminService {
    private final String adminName = "admin";
    private final String adminPassword = "1234";

    public boolean login(String name, String password) {
        return adminName.equals(name) && adminPassword.equals(password);
    }
}

