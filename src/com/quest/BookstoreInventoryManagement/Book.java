package com.quest.BookstoreInventoryManagement;

public class Book {
    private String title;
    private String author;
    private double price;
    private int stock;
    public static final double DISCOUNT_PERCENTAGE = 10.0;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }

    // Method to purchase books
    public void purchase(int quantity) throws OutOfStockException {
        if (quantity > stock) {
            throw new OutOfStockException("Not enough stock for " + title); //throws exception if stock is insufficient
        }
        stock -= quantity; // Reduce quantity from stock
        System.out.println(quantity + " copies of \"" + title + "\" purchased successfully!");
    }

    // provide book details
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: " + price + ", Stock: " + stock;
    }
}
