package ATM.management.project;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
   private String name;
   private ArrayList<User> users;
   private ArrayList<Account> accounts;


   //methods
   public StringBuilder getNewUserID(){
      //initialize
      StringBuilder uuID;
      Random rd = new Random();
      int len = 6;
      boolean nonUnique = false;

      //continue looping until we get a unique ID
      do {
         //generate the number
         uuID = new StringBuilder();
         for (int c = 0; c < len; c++){
            //add that character to uuID
            uuID.append(rd.nextInt(10));
         }

         //check to make sure it's unique
         for(User user : this.users){
            if(uuID.compareTo(new StringBuilder(user.getUUID())) == 0){
               nonUnique = true;
               break;
            }
         }

      }while(nonUnique);


      return uuID;
   }

   public StringBuilder getNewAccountID(){
      //initialize
      StringBuilder uuID;
      Random rd = new Random();
      int len = 10;
      boolean nonUnique = false;

      //continue looping until we get a unique ID
      do {
         //generate the number
         uuID = new StringBuilder();
         for (int c = 0; c < len; c++){
            //add that character to uuID
            uuID.append(rd.nextInt(10));
         }

         //check to make sure it's unique
         for(Account account : this.accounts){
            if(uuID.compareTo(new StringBuilder(account.getUUID())) == 0){
               nonUnique = true;
               break;
            }
         }

      }while(nonUnique);


      return uuID;
   }
   //constructor
   public User addUser(String firstName, String lastName, String pin){
      //create a new User object and add it to our list
      User newUser = new User(firstName, lastName, pin.getBytes(), this);
      this.users.add(newUser);

      //create a savings account for the user
      Account newAccount = new Account("Savings", newUser, this);
      newUser.addAccount(newAccount);
      this.addAccount(newAccount);

      return newUser;
   }

   //Constructor
   Bank(String name){
      this.name = name;

      //initializing users & accounts to an empty ArrayList
      this.users = new ArrayList<User>();
      this.accounts = new ArrayList<Account>();
   }



   //methods
   public void addAccount(Account account){
      this.accounts.add(account);
   }

   //
   public User userLogin(String userID, String pin){
      //search through list of users
      for(User user : this.users){
         //check if the userID is correct
         if(user.getUUID().compareTo(userID) == 0 && user.validatePin(pin)){
            return user;
         }
      }

      return null;
   }

   public String getName() {
      return name;
   }
}

