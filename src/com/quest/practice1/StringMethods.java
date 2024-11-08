package com.quest.practice1;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        charAtExample();
        concatExample();
        containsExample();
        equalsExample();
        equalsIgnoreCaseExample();
        lengthExample();
        isEmptyExample();
        substringExample();
        replaceExample();
        indexOfExample();
        lastIndexOfExample();
        toUpperCaseExample();
        toLowerCaseExample();
        startsWithExample();
        endsWithExample();
    }

   static public void charAtExample() {
        String str = "Adithya";
        System.out.println("charAt(1): " + str.charAt(1));
    }

   static public void concatExample() {
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("concat: " + str1.concat(" " + str2));
    }

   static public void containsExample() {
        String str = "Hello";
        System.out.println("contains : " + str.contains("ell"));
    }

    static public void equalsExample() {
        System.out.println("equals: " + "Hello".equals("Hello"));
    }

    static public void equalsIgnoreCaseExample() {
        System.out.println("equalsIgnoreCase: " + "ADITHYA".equalsIgnoreCase("adithya"));
    }

    static public void lengthExample() {
        String str = "Hello";
        System.out.println("length: " + str.length());
    }

    static public void isEmptyExample() {
        String emptyStr = "";
        System.out.println("isEmpty: " + emptyStr.isEmpty());
    }

    static public void substringExample() {
        String str = "Hello";
        System.out.println("substring(1): " + str.substring(1));
        System.out.println("substring(1, 4): " + str.substring(1, 4));//start and end index
    }

    static public void replaceExample() {
        String str = "Hello";
        System.out.println("replace " + str.replace('e', 'a')); //old-new
    }


    //  Returns the index of the first occurrence of the specified character
    static public void indexOfExample() {
        String str = "Hello";
        System.out.println("indexOf 'e': " + str.indexOf('e'));
    }
    //Returns the index of the last occurrence of the specified character
    static public void lastIndexOfExample() {
        String repeat = "HelloHello";
        System.out.println("lastIndexOf 'o': " + repeat.lastIndexOf('o'));
    }

    static public void toUpperCaseExample() {
        String str = "Hello";
        System.out.println("toUpperCase: " + str.toUpperCase());
    }

    static public void toLowerCaseExample() {
        String str = "Hello";
        System.out.println("toLowerCase: " + str.toLowerCase());
    }

    static public void startsWithExample() {
        String str = "Hello";
        System.out.println("startsWith 'He': " + str.startsWith("He"));
    }

    static public void endsWithExample() {
        String str = "Hello";
        System.out.println("endsWith 'lo': " + str.endsWith("lo"));
    }


    }

