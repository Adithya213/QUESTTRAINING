package com.quest.ExceptionClass2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee employee = null;
        Manager manager = null;

        while (true) {
            try {
                System.out.println("Enter Employee details:");
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Age: ");
                int age = scanner.nextInt();

                System.out.print("Salary: ");
                double salary = scanner.nextDouble();

                employee = new Employee(name, age, salary);
                break;
            } catch (InvalidInputException e) {
                System.out.println("InvalidInputException: " + e.getMessage() + " Please re-enter details.");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException: Invalid data type entered. Please re-enter details.");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                scanner.nextLine();
                System.out.println("Enter Manager details:");
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Age: ");
                int age = scanner.nextInt();

                System.out.print("Salary: ");
                double salary = scanner.nextDouble();

                System.out.print("Team Size: ");
                int teamSize = scanner.nextInt();

                manager = new Manager(name, age, salary, teamSize);
                break;
            } catch (InvalidInputException e) {
                System.out.println("InvalidInputException: " + e.getMessage() + " Please re-enter details.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException: " + e.getMessage() + " Please re-enter details.");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException: Invalid data type entered. Please re-enter details.");
                scanner.nextLine();
            }
        }

        // Display details
        System.out.println("\nEmployee Details:");
        employee.displayDetails();

        System.out.println("\nManager Details:");
        manager.displayDetails();
        System.out.println(manager);
    }
}
