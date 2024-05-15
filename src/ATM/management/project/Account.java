package ATM.management.project;

import java.util.ArrayList;

public class Account {
    private final String name;
    private String uuID;
    private User holder;
    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank bank) {
        //set the account name and holder
        this.name = name;
        this.holder = holder;

        //get a new uuID for the account
        this.uuID = String.valueOf(bank.getNewAccountID());

        //initialize transactions to an empty array
        this.transactions = new ArrayList<Transaction>();



    }

    //methods
    public String getUUID(){
        return this.uuID;
    }

    public String getSummaryLine(){
        //get the balance
        double balance = this.getBalance();

        //format the summary line, depending on the whether the balance is negative
        if(balance >= 0){
            return String.format("%s : $%.02f : %s", this.uuID, balance, this.name);
        }else{
            return String.format("%s : $(%.02f) : %s", this.uuID, balance, this.name);

        }
    }

    public double getBalance(){
        double balance = 0;
        for (Transaction t : this.transactions){
            balance += t.getAmount();
        }

        return balance;
    }


    public void printTransHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.uuID);

        for (int t = this.transactions.size()-1; t >= 0; t--){
            System.out.println(this.transactions.get(t).getSummaryLine());
        }

        System.out.println();
    }


    public void addTransaction(double amount, String memo) {
        //create new transaction object and add it to our list
        Transaction newTrans = new Transaction(amount, this, memo);
        this.transactions.add(newTrans);
    }
}

