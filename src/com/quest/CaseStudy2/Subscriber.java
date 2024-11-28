package com.quest.CaseStudy2;

import java.io.Serializable;

public class Subscriber implements Serializable {
    private int id;// Unique ID for the subscriber
    private String name;
    private String phoneNumber;
    private String planType;// Plan type- prepaid or postpaid
    private double balance;// Balance -used for Prepaid plans

    public Subscriber(int id, String name, String phoneNumber, String planType, double balance) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.planType = planType;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPlanType() {
        return planType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;//update balance for prepaid
    }

    @Override
    public String toString() {
        return "Subscriber [ID=" + id + ", Name=" + name + ", Phone=" + phoneNumber +
                ", Plan=" + planType + ", Balance=" + balance + "]";
    }
}
