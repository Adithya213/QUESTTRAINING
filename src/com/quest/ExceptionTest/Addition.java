package com.quest.ExceptionTest;

class Addition extends CalculatorOperation {
    private double n1;
    private double n2;

    public Addition(double num1, double num2) {
        this.n1 = num1;
        this.n2 = num2;
    }

    @Override
    public String performOperation() {
        return String.valueOf(n1 + n2); // converting double to string representation
    }
}

