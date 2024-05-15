package ATM.management.project;

import java.util.Scanner;

//Interface of the Bank
public class ATM {
    public static void main(String[] args) {
        //initialize scanner
        Scanner sc = new Scanner(System.in);

        //initialize Bank
        Bank bank = new Bank("Gurmad's Bank");

        //add a user, which also creates a savings account
        User user = bank.addUser("Kaah", "Harir", "1234");

        //add a checking account for our user
        Account account = new Account("Checking", user, bank);
        user.addAccount(account);
        bank.addAccount(account);

        //login prompt
        User currUser;
        while (true){
            //stay in the login prompt until a successful login
            currUser = ATM.mainMenuPrompt(bank, sc);

            //stay in the man menu until the user quits
            ATM.printUserMenu(currUser, sc);
        }
    }

    //methods
    public static User mainMenuPrompt(Bank bank, Scanner sc){
        //init
        String userID;
        String pin;
        User authUser;

        //prompt the user for user ID/pin combo until a correct one is reached
        do {
            System.out.println("\nWelcome to " + bank.getName());
            System.out.print("\nEnter your userID: ");
            userID = sc.nextLine();

            System.out.print("Enter your pin: ");
            pin = sc.nextLine();

            //trying to get the user object corresponding to the ID and pin combo
            authUser = bank.userLogin(userID, pin);
            if(authUser == null){
                //if someone is trying to hack, they don't know which one, so just print userID / pin is incorrect.
                System.out.println("Incorrect userID / pin combination!, Please try again.");
            }

        //continue looping until a successful login.
        }while (authUser == null);

        return authUser;
    }

    public static void printUserMenu(User user, Scanner sc){
        //print a summary of the user's accounts
        user.printAccountsSummary();

        //init
        int choice;

        //user menu
        do {
            System.out.println("\nWelcome " + user.getFirstName() + ", What would you like to do?\n");
            //some options
            System.out.println(" 1) Show account's transaction history");
            System.out.println(" 2) Make a withdraw");
            System.out.println(" 3) Make a deposit");
            System.out.println(" 4) Transfer ");
            System.out.println(" 5) Quit");
            //prompt to enter a choice
            System.out.print("\nEnter a choice: ");
            choice = sc.nextInt();

            //handle exceptions
            if(choice < 1 || choice > 5){
                System.out.println("Invalid choice!, Please choose 1-5.");
            }

        } while (choice < 1 || choice > 5);

        //after that process the choice
        switch (choice){
            case 1:
                ATM.showTransactionHistory(user, sc);
                break;
            case 2:
                ATM.wthdrawFunds(user, sc);
                break;
            case 3:
                ATM.depositFunds(user, sc);
                break;
            case 4:
                ATM.transferFunds(user, sc);
                break;
        }

        //re-display this menu unless the user quits
        if(choice != 5){
            ATM.printUserMenu(user, sc);
        }
    }



    private static void showTransactionHistory(User user, Scanner sc) {
        int theAccount;

        //which account to look
        do {
            System.out.printf("Enter the account number (1-%d), whose transactions you want to see: ", user.noOfAccounts());

            //store that
            theAccount = sc.nextInt() -1;

            //process
            if(theAccount < 0 || theAccount >= user.noOfAccounts()){
                System.out.println("Invalid account!, please try again.");
            }
        }while (theAccount < 0 || theAccount >= user.noOfAccounts());

        //once, we've that account then we print the transaction history
        user.printAccountTransactionHistory(theAccount);
        

    }

    private static void wthdrawFunds(User user, Scanner sc) {
        //init
        int fromAccount;
        double amount;
        double accountBalance;
        String memo;

        //get the account to withdraw from
        do {
            System.out.printf("Enter the number (1-%d) of the account: ", user.noOfAccounts());
            fromAccount = sc.nextInt()-1;

            //handle this exception
            if(fromAccount < 0 || fromAccount >= user.noOfAccounts()){
                System.out.println("Invalid Account!, Please try again.");

            }
        }while (fromAccount < 0 || fromAccount >= user.noOfAccounts());
        accountBalance = user.getAccountBalance(fromAccount);

        //get the amount to withdraw
        do {
            System.out.printf("Enter the amount to withdraw (max $%.02f): $", accountBalance);
            amount = sc.nextDouble();

            if(amount <= 0){
                System.out.println("Amount must be greater than zero!.");
            } else if (amount > accountBalance) {
                System.out.println("Insufficient funds!, Please try again.");
            }
        }while ((amount <= 0 || amount > accountBalance));

        //gobble up the rest of the previous input line
        sc.nextLine();

        //get the memo
        System.out.print("Enter a memo: ");
        memo = sc.nextLine();

        //do the withdrawal
        user.addAccountTransaction(fromAccount, -1 * amount, memo);
    }

    private static void depositFunds(User user, Scanner sc) {
        //init
        int toAccount;
        double amount;
        double accountBalance;
        String memo;

        //get the account to transfer form
        do {
            System.out.printf("Enter the number (1-%d) of the account: ", user.noOfAccounts());
            toAccount = sc.nextInt()-1;

            //handle this exception
            if(toAccount < 0 || toAccount >= user.noOfAccounts()){
                System.out.println("Invalid Account!, Please try again.");

            }
        }while (toAccount < 0 || toAccount >= user.noOfAccounts());
        accountBalance = user.getAccountBalance(toAccount);

        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to deposit in: $");
            amount = sc.nextDouble();

            if(amount <= 0){
                System.out.println("\nAmount must be greater than zero!.");
            }
        }while (amount <= 0);

        //gobble up the rest of the previous input line
        sc.nextLine();

        //get the memo
        System.out.print("Enter a memo: ");
        memo = sc.nextLine();

        //do the withdrawal
        user.addAccountTransaction(toAccount, amount, memo);

        //finally, display a message
        System.out.printf("\nYou have deposited $%s successfully.", amount);
        System.out.println();

    }

    private static void transferFunds(User user, Scanner sc) {
        //init
        int fromAccount;
        int toAccount;
        double amount;
        double accountBalance;

        //get the account to transfer form
        do {
            System.out.printf("Enter the account no (1-%d) to transfer from: ", user.noOfAccounts());
            fromAccount = sc.nextInt()-1;

            //handle this exception
            if(fromAccount < 0 || fromAccount >= user.noOfAccounts()){
                System.out.println("Invalid Account!, Please try again.");

            }
        }while (fromAccount < 0 || fromAccount >= user.noOfAccounts());

        //once we've a valid account, then lets get the account balance
        accountBalance = user.getAccountBalance(fromAccount);

        //get the account to transfer to
        do {
            System.out.printf("Enter the account no (1-%d) to transfer to: ", user.noOfAccounts());
            toAccount = sc.nextInt()-1;

            //handle this exception
            if(toAccount < 0 || toAccount >= user.noOfAccounts()){
                System.out.println("Invalid Account!, Please try again.");

            }
        }while (toAccount < 0 || toAccount >= user.noOfAccounts());

        //get the amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $", accountBalance);
            amount = sc.nextDouble();

            if(amount <= 0){
                System.out.println("Amount must be greater than zero!.");
            } else if (amount > accountBalance) {
                System.out.println("Insufficient funds!, Please try again.");
            }
        }while (amount <= 0 || amount > accountBalance);

        //finally, do the transfer
        user.addAccountTransaction(fromAccount, -1 * amount, String.format("Transfer to account %s", user.getAccountUUID(toAccount)));
        user.addAccountTransaction(toAccount, amount, String.format("Transfer to account %s", user.getAccountUUID(fromAccount)));

    }

}
