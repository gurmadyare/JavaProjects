package email.generator.application;

import java.util.Arrays;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private int mailboxCapacity;
    private String email;
    private String password;
    private final String companySuffix = "company.com";

    //Constructor
    Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //display a message for the new worker
        System.out.printf("New worker: %s, %s. \n", this.lastName, this.firstName );

        //call the method setDept()
        this.department = setDept();
        System.out.println("Dept: " + (this.department.isEmpty() ? "Invalid dept choice!" : this.department) + "\n");

        //combine elements to generate email
        if(department.length() >= 1){
            this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
            System.out.println("Your email will be: " + this.email);

        }else{
            System.err.println("Department is empty!");
        }

        //call the method for generating randPass..
        this.password = generateRandomPassword(8);

        System.out.println("Your password will be: " + this.password);


    }

    //Ask for the department
    private String setDept(){
        System.out.println("\nDepartments -> \n\n1) For sales \n2) For dev \n3) For accounting \n0) For none!  \n");
        System.out.print("Enter the department no: ");

        Scanner sc = new Scanner(System.in);
        int deptChoice = sc.nextInt();

        return switch (deptChoice) {
            case 1 -> "sales";
            case 2 -> "development";
            case 3 -> "accounting";

            default -> "";
        };
    }

    //Generate a random password
    private String generateRandomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@$#";
        char[] password = new char[length];

        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());

            password[i] = passwordSet.charAt(rand);
        }

        return String.valueOf(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set alternate email
    public void setAlternateEmail(String altEmail){
        this.email = email;
    }

    //change password
    public void changePassword(String newPass){
        this.password = newPass;
    }

    //Getters

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //showInfo
    public String showInfo(){
        return "\nName: " + firstName + " " + lastName +
                "\nCompany email: " + email +
                "\nDept: " + department +
                "\nPassword: " + password;
    }
}
