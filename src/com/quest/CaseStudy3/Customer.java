package com.quest.CaseStudy3;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private List<Vehicle> purchasedVehicles;

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.purchasedVehicles = new ArrayList<>();
    }

    public void addPurchasedVehicle(Vehicle vehicle) {
        purchasedVehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", purchasedVehicles=" + purchasedVehicles +
                '}';
    }
}
