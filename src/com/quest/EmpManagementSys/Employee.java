package com.quest.EmpManagementSys;
//public non-abstract class
class Employee {
    //private data-members
    private String name;
    private double baseSalary;
    private double[] monthlySalaries = new double[12];

    //assigning values to variables with constructor
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    //public getter & setter method
    public String getName() { // it is returning a name which is of string type
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double[] getMonthlySalaries() { //returns the monthly salary array.
        return monthlySalaries;
    }
    // Setting salary for a particular month using setter()
    public void setMonthlySalary(int month, double salary) {//it will take 2 para. with no returntype
        if (month >= 1 && month <= 12) { // checks if the month value is valid (1-12) before storing in array
            this.monthlySalaries[month - 1] = salary; // for jan-1 (so we subtracct 1 to store jan in index 0)
        }
    }
    //Annual Salary Calculation
    public double calculateTotalSalary() {
        double total = 0;
        //for-each loop for object traversal
        for (double sal : monthlySalaries) { //accessing each monthly salary in array
            total += sal;
        }
        return total;
    }
    //Average-Monthly Salary Calculation
    public double calculateAverageMonthlySalary() {
        return calculateTotalSalary() / 12; // it will divide total salary by 12
    }
 // Bonus Calculator
    public double calculateBonus() {
        return baseSalary * 0.1; // returns 10% of base-sal as bonus
    }
}

