package com.quest.CaseStudy3;

import java.time.LocalDate;

public class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double price;
    private LocalDate manufactureDate;

    public Vehicle(String vehicleId, String brand, String model, double price, LocalDate manufactureDate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.manufactureDate = manufactureDate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' + ", brand='" + brand + '\'' + ", model='" + model + '\'' +
                ", price=" + price + ", manufactureDate=" + manufactureDate + '}';
    }
}
