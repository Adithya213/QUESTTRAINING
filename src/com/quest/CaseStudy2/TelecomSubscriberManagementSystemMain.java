package com.quest.CaseStudy2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelecomSubscriberManagementSystemMain {
    public static void main(String[] args) {
        Tsms tsms = new Tsms();
        String filename = "tsms_data.dat";

        // Load data when the program starts
        tsms.loadData(filename);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            try {
                System.out.println("\n!!! Welcome To Telecom Subscriber Management System !!!");
                System.out.println("1. Add Subscriber(Enter a Numeric value)");
                System.out.println("2. Update Subscriber Balance");
                System.out.println("3. List Subscribers");
                System.out.println("4. Record Log Call");
                System.out.println("5. View Call History");
                System.out.println("6. Generate Bill");
                System.out.println("7. Exit and Save");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt(); // Handle InputMismatchException
                scanner.nextLine();

                switch (choice) {
                    case 1: // Add Subscriber
                        try {
                            System.out.print("Enter Subscriber ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Phone Number: ");
                            String phone = scanner.nextLine();
                            System.out.print("Enter Plan Type (Prepaid/Postpaid): ");
                            String planType = scanner.nextLine();
                            System.out.print("Enter Initial Balance: ");
                            double balance = scanner.nextDouble();

                            tsms.addSubscriber(new Subscriber(id, name, phone, planType, balance));
                            System.out.println("Subscriber added successfully.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter correct data types.");
                            scanner.nextLine();
                        }
                        break;

                    case 2: // Update Subscriber Balance
                        try {
                            System.out.print("Enter Subscriber ID: ");
                            int id = scanner.nextInt();
                            System.out.print("Enter New Balance: ");
                            double balance = scanner.nextDouble();

                            tsms.updateSubscriberBalance(id, balance);
                            System.out.println("Balance updated successfully.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a number for ID and Balance.");
                            scanner.nextLine();
                        }
                        break;

                    case 3: // List Subscribers
                        tsms.listSubscribers();
                        break;

                    case 4: // Log Call
                        try {
                            System.out.print("Enter Subscriber ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter Call Type (Local/STD/ISD): ");
                            String type = scanner.nextLine();
                            System.out.print("Enter Call Duration (in minutes): ");
                            int duration = scanner.nextInt();

                            tsms.logCall(id, new CallRecord(type, duration));
                            System.out.println("Call logged successfully.");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter correct data types.");
                            scanner.nextLine();
                        }
                        break;

                    case 5: // View Call History
                        try {
                            System.out.print("Enter Subscriber ID: ");
                            int id = scanner.nextInt();
                            tsms.viewCallHistory(id);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Subscriber ID must be a number.");
                            scanner.nextLine();
                        }
                        break;

                    case 6: // Generate Bill
                        try {
                            System.out.print("Enter Subscriber ID: ");
                            int id = scanner.nextInt();
                            tsms.generateBill(id);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Subscriber ID must be a number.");
                            scanner.nextLine();
                        }
                        break;

                    case 7: // Exit
                        tsms.saveData(filename); //saving data with filename
                        System.out.println("Thank you for using the TSMS!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number for your choice.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        } while (choice != 7);

        scanner.close();
    }
}
