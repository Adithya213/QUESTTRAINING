package com.quest.BankAccountManagementSystem;

// Inheritance: CurrentAccount
public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 1000;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Current");
        System.out.println("Overdraft Limit: $" + OVERDRAFT_LIMIT);
    }
}
