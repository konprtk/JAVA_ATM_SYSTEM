package com.ATM;
import java.util.InputMismatchException;
import java.util.Scanner;

class ATM extends AtmPinVerification {
    private double balance;

    public ATM() {
        balance = 0.0;
    }

    public void deposit(double amt) {
        if (amt <= 0) {
    
            throw new LessThanZeroException();
        }
        balance += amt;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amt) throws InsufficientBalanceException {
        if (amt <= 0) {
            throw new LessThanZeroException();
        }
        if ((amt +500)> balance) {
            throw new InsufficientBalanceException();
        }
        balance -= amt;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner prtk = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = prtk.next();
        System.out.println("Welcome..!!" + name);
        while(true) {
        try {
        atm.pinVerify();

        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Change Pin");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            try {
                int opt = prtk.nextInt();
                switch (opt) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double dAmount = prtk.nextDouble();
                        atm.deposit(dAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double wAmount = prtk.nextDouble();
                        atm.withdraw(wAmount);
                        break;

                    case 3:
                        System.out.println("Current balance: " + atm.getBalance());
                        break;

                    case 4:
                    	//System.out.println("Sorry for Inconvenience..!!\nI am working on this Service");
                    	
                    		atm.ChangePin();
                    	break;
                       
                    case 5:
                        System.out.println("Thank you! For using ATM made by Pratik");
                        return ;
                   
                    default:
                        System.out.println("Invalid option. Please select a valid option.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("Insufficient Balance..!! Account required minimum INR 500 to be Active");
            } 
            catch(LessThanZeroException e) {
            	System.out.println("We can't Widraw/Deposit Amount less than Zero");
            }
            catch(NotAuthorisedException e) {
            	System.out.println("You can't Login..!! You are not Authorised!");
            }
            catch (Exception e) {
                System.out.println("Invalid input...! Please enter a valid number.");
               prtk.nextLine(); // it clear input buffer i guess
            }
        }
       }
        catch(InputMismatchException e) {
        	System.out.println("Invalid input...! Please enter a valid number.");
        
    }
        
        }
    }
}
        
