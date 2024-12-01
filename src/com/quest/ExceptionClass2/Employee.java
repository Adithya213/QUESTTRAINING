package com.quest.ExceptionClass2;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) throws InvalidInputException {
        validateEmployeeInput(age, salary);
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //method for validation
    private void validateEmployeeInput(int age, double salary) throws InvalidInputException {
        if (age < 18) {
            throw new InvalidInputException("Age must be 18 or older.");
        }
        if (salary < 0) {
            throw new InvalidInputException("Salary cannot be negative.");
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public final void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
    }
}
