package Bank_Project;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

class Transaction implements Serializable {
    private String type; // Deposit or Withdraw
    private double amount;
    private String date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}
