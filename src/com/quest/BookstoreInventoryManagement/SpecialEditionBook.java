package com.quest.BookstoreInventoryManagement;

public class SpecialEditionBook extends Book {
    private String specialFeature;

    // Constructor to initialize fields of both parent and child classes
    public SpecialEditionBook(String title, String author, double price, int stock, String specialFeature) {
        super(title, author, price, stock); // Initialize parent fields using super
        this.specialFeature = specialFeature;
    }

    // Override toString to include the special feature
    @Override
    public String toString() {
        return super.toString() + ", Special Feature: " + specialFeature;
    }
}

