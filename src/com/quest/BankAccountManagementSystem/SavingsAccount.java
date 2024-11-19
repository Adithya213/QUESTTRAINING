package com.quest.BankAccountManagementSystem;

// Inheritance: SavingsAccount
public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 500;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Savings");
        System.out.println("Minimum Balance: $" + MINIMUM_BALANCE);
    }
}
