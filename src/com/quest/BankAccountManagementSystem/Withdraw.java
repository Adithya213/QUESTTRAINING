package com.quest.BankAccountManagementSystem;
// Concrete Transaction: Withdraw
public class Withdraw extends Transaction {
    public Withdraw(BankAccount account) {
        super(account);
    }

    @Override
    public void processTransaction(double amount) {
        if (amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdraw $" + amount + ". New Balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }
}

