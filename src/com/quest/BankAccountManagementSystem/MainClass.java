package com.quest.BankAccountManagementSystem;

import java.util.Scanner;

public class MainClass {
    private static final int MAX_ACCOUNTS = 100; // Max account we can create & store acc obj
    private static BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];// to store created account
    private static int accountCount = 0;//count of created acc

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount(scanner, "Savings");
                    break;

                case 2:
                    createAccount(scanner, "Current");
                    break;

                case 3:
                    performTransaction(scanner, "Deposit");
                    break;

                case 4:
                    performTransaction(scanner, "Withdraw");
                    break;

                case 5:
                    viewAccountDetails(scanner);
                    break;

                case 6:
                    System.out.println("Exiting...\n------ThankYOU Visit Again-------");
                     return;

                default:
                    System.out.println("Invalid choice! Please try again--.");
            }
        }
    }

    // Method to create accounts
    private static void createAccount(Scanner scanner, String accountType) {
        if (accountCount >= MAX_ACCOUNTS) {//100-max
            System.out.println("Cannot create more accounts. Maximum limit reached.");
            return;
        }

        System.out.print("Enter Unique Account Number: ");
        String accountNumber = scanner.nextLine();
        if (isAccountNumberExists(accountNumber)) { // checking if account already exist
            System.out.println("Account number already exists. Please use a unique account number.");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter Initial Balance(Enter +ve value): ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        BankAccount account; //obj for bankaccount
        if (accountType.equals("Savings")) {
            account = new SavingsAccount(accountNumber, accountHolderName, balance);
        } else {
            account = new CurrentAccount(accountNumber, accountHolderName, balance);
        }

        accounts[accountCount++] = account; //count and store in array
        System.out.println(accountType + " Account created successfully!");
    }

    // Method to check if account no already present or not
    private static boolean isAccountNumberExists(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    // Method to perform transactions
    private static void performTransaction(Scanner scanner, String transactionType) {
        System.out.print("Enter Valid Account Number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = findAccount(accountNumber);//callin-find account by acc no.

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Transaction transaction;
        if (transactionType.equals("Deposit")) {
            transaction = new Deposit(account); //deposit
        } else {
            transaction = new Withdraw(account); // withdraw
        }
         //now transaction contain object of withdraw or deposit
        transaction.processTransaction(amount); //invoke with the obj
    }

    // Method to view account details
    private static void viewAccountDetails(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = findAccount(accountNumber);

        if (account != null) {
            account.displayAccountDetails();//call
        } else {
            System.out.println("Account not found!");
        }
    }

    // Method to find an account by account number
    private static BankAccount findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) { //check no in array
                return accounts[i];
            }
        }
        return null;
    }
}
