package com.quest.VehicleOop;

public class Car extends Vehicle implements VehicleFeatures {
    String model;

    public Car(String name, String model) {
        //super(name);
        this.model = model;
    }

    @Override
    public void fuelType() {
        System.out.println("Car uses petrol or diesel.");
    }

    @Override
    public void startEngine() {//interface method
        System.out.println("Car engine started with a key.");
    }

    // Method with a final keyword as para
    public void displayModel(final String ownerName) {
        System.out.println("Owner: " + ownerName + " Model: " + model);
        // ownerName = "Leena"; // Now we cannot change the variable
    }

    @Override
    public String toString() {
        return "Car name=" + name + ",model=" + model ;
    }
}

