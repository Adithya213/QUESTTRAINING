package com.quest.ExceptionTest;

class StringConcatenation extends CalculatorOperation {
    private String str1;
    private String str2;

    public StringConcatenation(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public String performOperation() {
        try {
            if (str1 == null || str2 == null) {

                throw new NullPointerException("String is null.");
            }
            String result = str1 + str2;
            char test = result.charAt(result.length() + 1);
        } catch (NullPointerException e) {
            return "Error: One of the strings is null!";
        } catch (StringIndexOutOfBoundsException e) {
            return "Error: String index out of bounds!";
        }
        return str1 + str2;
    }
}


