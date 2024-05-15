package ATM.management.project;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class User {
    //name of the user
    private String firstName;
    private String lastName;

    //Universal unique Identifier (id code for the user)
    private final String uuID;

    //The MD5 hash of the user's pin
    private byte[] pinHash;

    //The list of accounts of this user
    private ArrayList<Account> accounts;


    public User(String firstName, String lastName, byte[] pinHash, Bank bank) {
        //setting user's name
        this.firstName = firstName;
        this.lastName = lastName;

        //store the pin's MD5 hash rather than the original value, for security reasons.
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pinHash);
        }catch (NoSuchAlgorithmException e){
            System.err.println("Error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //get a new unique universal ID for the user (uuID)
        this.uuID = String.valueOf(bank.getNewUserID());

        //create empty list of accounts
        this.accounts = new ArrayList<Account>();

        //finally, print a message to the user.
        System.out.println("New user " + lastName + ", " + firstName + " with ID " + uuID + " created.");

    }

    //methods
    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public String getUUID(){
        return this.uuID;
    }

    public boolean validatePin(String pin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //check if there are equal
            return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
        }catch (NoSuchAlgorithmException e){
            System.err.println("Error!, NoSuchAlgorithmException happened.");
            e.printStackTrace();
            System.exit(1);
        }

        return false;
    }


    public String getFirstName() {
        return firstName;
    }

    public void printAccountsSummary(){
        System.out.println("\nAccount summary of " + this.firstName);
        for(int a = 0; a < this.accounts.size(); a++){
            System.out.printf("%d) %s\n", a+1, this.accounts.get(a).getSummaryLine());
        }
    }

    public int noOfAccounts() {
        return this.accounts.size();
    }

    public void printAccountTransactionHistory(int accountIndex) {
        this.accounts.get(accountIndex).printTransHistory();
    }

    public double getAccountBalance(int accountIndex) {
        return this.accounts.get(accountIndex).getBalance();
    }

    public String getAccountUUID(int accountIndex) {
        return this.accounts.get(accountIndex).getUUID();
    }

    public void addAccountTransaction(int accountIndex, double amount, String memo) {
        this.accounts.get(accountIndex).addTransaction(amount, memo);

    }
}
