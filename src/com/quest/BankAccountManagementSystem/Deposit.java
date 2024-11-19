package com.quest.BankAccountManagementSystem;

public class Deposit extends Transaction {
    public Deposit(BankAccount account) {
        super(account);
    }

    @Override
    public void processTransaction(double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposited $" + amount + ". New Balance: $" + account.getBalance());
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }
}
