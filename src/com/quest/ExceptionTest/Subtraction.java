package com.quest.ExceptionTest;

class Subtraction extends CalculatorOperation {
    private double n1;
    private double n2;

    public Subtraction(double num1, double num2) {
        this.n1 = num1;
        this.n2 = num2;
    }
    @Override
    public String performOperation() {
        return String.valueOf(n1 - n2);
    }
}

