package com.quest.BankAccountManagementSystem;

public abstract class Transaction {
    protected BankAccount account;

    public Transaction(BankAccount account) {
        this.account = account;
    }

    public abstract void processTransaction(double amount);
}
