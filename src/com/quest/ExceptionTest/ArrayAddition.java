package com.quest.ExceptionTest;

class ArrayAddition extends CalculatorOperation {
    private int[] numbers;

    public ArrayAddition(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String performOperation() {
        int sum = 0;
        try {
            for (int i = 0; i <= numbers.length; i++) {
                sum += numbers[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error: Array index out of bounds!";
        }
        return String.valueOf(sum);
    }
}



