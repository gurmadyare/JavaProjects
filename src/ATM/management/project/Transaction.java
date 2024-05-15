package ATM.management.project;
import java.util.Date;

public class Transaction {
    private double amount;
    private Date timeStamp;
    private String memo;
    private Account inAccount;

    //constructors
    public Transaction(double amount, Account inAccount){
        setAmount(amount);
        this.inAccount = inAccount;
        this.timeStamp = new Date();
        this.memo = "";
    }
    public Transaction(double amount, Account inAccount, String memo){
        setAmount(amount);
        this.inAccount = inAccount;
        this.timeStamp = new Date();
        this.memo = memo;
    }

    public void setAmount(double amount) {
           this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getSummaryLine() {
        if(this.amount >= 0){
            return String.format("%s : $%.02f : %s", this.timeStamp.toString(), this.amount, this.memo);
        }else {
            return String.format("%s : $(%.02f) : %s", this.timeStamp.toString(), -this.amount, this.memo);
        }
    }
}
