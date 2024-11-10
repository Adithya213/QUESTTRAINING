package com.quest.EmpManagementSys;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int noOfEmp = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Employee[] employees = new Employee[noOfEmp]; //creating array to store emp obj(details).so Employee class is the datatype

        for (int i = 0; i < noOfEmp; i++) {
            System.out.print("Enter the name of employee " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter the base salary for " + name + ": ");
            double baseSalary = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            Employee employee = new Employee(name, baseSalary); //creating object and pass name and baseSal.
            for (int month = 1; month <= 12; month++) {
                System.out.print("Enter salary for month " + month + "(0-100000): ");
                double salary = scanner.nextDouble();
                while (salary < 0 || salary > 100000) { // i/p validation
                    System.out.print("Invalid input. Enter salary for month " + month + "(0-100000): ");
                    salary = scanner.nextDouble();
                }
                employee.setMonthlySalary(month, salary);
            }
            scanner.nextLine();
            employees[i] = employee; // then store each emp obj in array
        }

        //................... Generate Report....
        System.out.println("\n--- Employee Salary Report ---");
        double totalAverageSalary = 0;

       //using for-each to Loop through each employee in the array
        for (Employee employee : employees) {
            System.out.println("\nEmployee Name: " + employee.getName());//calling getter method
            System.out.println("Base Salary: " + employee.getBaseSalary());
            // For each month, print the salary from the employee's monthly salary array
            System.out.println("Monthly Salary Breakdown:");
            for (int month = 1; month <= 12; month++) {
                System.out.println("  Month " + month + ": " + employee.getMonthlySalaries()[month - 1]);
            }

            double totalSalary = employee.calculateTotalSalary();//Annual sal(sum of monthly salaries)
            System.out.println("Total Salary for the Year: " + totalSalary);
            double averageMonthlySalary = employee.calculateAverageMonthlySalary(); //avg monthly sal
            System.out.println("Average Monthly Salary: " + averageMonthlySalary);
            System.out.println("Bonus: " + employee.calculateBonus()); // bonus

            totalAverageSalary += averageMonthlySalary;//Add the avg monthly sal of current emp to the total avg sal
        }

        System.out.println("\nAverage Salary for All Employees: " + (totalAverageSalary / noOfEmp)); // avg sal of all
        System.out.println("\nThank you for using the Employee Salary Management System.");

        scanner.close();
    }
}

