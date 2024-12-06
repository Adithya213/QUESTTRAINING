package com.quest.CaseStudy3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] inventory = VehicleInventoryManager.addVehicle();
        Map<Customer, Set<Vehicle>> customerVehiclesMap = new HashMap<>();

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();
        Customer customer = new Customer(customerId, name, email);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. View Vehicles by Brand");
            System.out.println("2. Purchase Vehicle");
            System.out.println("3. View Customer Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Brand to Search: ");
                    String brand = scanner.nextLine();
                    VehicleInventoryManager.printVehiclesByBrand(inventory, brand);
                }
                case 2 -> {
                    System.out.print("Enter Vehicle ID to Purchase: ");
                    String vehicleId = scanner.nextLine();
                    try {
                        VehicleInventoryManager.purchaseVehicle(inventory, customer, customerVehiclesMap, vehicleId);
                        System.out.println("Vehicle purchased successfully!");
                    } catch (VehicleNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> System.out.println(customer);

                case 4 -> {
                    System.out.println("Exiting the program.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
