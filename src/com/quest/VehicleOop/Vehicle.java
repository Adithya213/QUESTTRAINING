package com.quest.VehicleOop;
public class Vehicle {
    String name;

    // Default constructor
    public Vehicle() {
        this.name = "Unknown Vehicle";
    }
    public Vehicle(String name) {
        this.name = name;
    }

    public void fuelType() {
        System.out.println("Vehicle uses petroleum.");
    }

    @Override
    public String toString() {
        return "Vehicle name=+" + name ;
    }
}

