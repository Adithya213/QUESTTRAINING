package com.quest.CaseStudy3;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class VehicleInventoryManager {
    public static Vehicle[] addVehicle() {
        Vehicle[] inventory = new Vehicle[5];
        inventory[0] = new Car("CAR001", "Tesla", "Model S", 79999.99, LocalDate.of(2023, 1, 15), 5);
        inventory[1] = new Car("CAR002", "BMW", "X5", 60999.99, LocalDate.of(2022, 7, 20), 7);
        inventory[2] = new Car("CAR003", "Mercedes", "C-Class", 41999.99, LocalDate.of(2021, 11, 5), 5);
        inventory[3] = new Bike("BIKE001", "Ducati", "Panigale V4", 25000.00, LocalDate.of(2023, 6, 18), 1103);
        inventory[4] = new Bike("BIKE002", "Kawasaki", "Ninja ZX-10R", 20000.00, LocalDate.of(2022, 4, 10), 998);
        return inventory;
    }

    public static void printVehiclesByBrand(Vehicle[] inventory, String brand) {
        List<Vehicle> vehicles = Arrays.stream(inventory)
                .filter(vehicle -> vehicle != null && vehicle.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found for brand: " + brand);
        } else {
            vehicles.forEach(System.out::println);
        }
    }

    public static void purchaseVehicle(Vehicle[] inventory, Customer customer, Map<Customer, Set<Vehicle>> customerVehicleMap, String vehicleId)
            throws VehicleNotAvailableException {
        Vehicle vehicleToPurchase = null;

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].getVehicleId().equals(vehicleId)) {
                vehicleToPurchase = inventory[i];
                inventory[i] = null;
                break;
            }
        }
        if (vehicleToPurchase == null) {
            throw new VehicleNotAvailableException("Vehicle " + vehicleId + " not available");
        }
        customer.addPurchasedVehicle(vehicleToPurchase);
        customerVehicleMap.computeIfAbsent(customer, k -> new HashSet<>()).add(vehicleToPurchase);
    }
}
