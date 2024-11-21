package com.quest.LibraryModified;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String ISBN, String title, String author, int publicationYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void displayDetails() {
        System.out.println("Book - ISBN: " + getISBN() + ", Title: " + getTitle() +
                ", Author: " + getAuthor() + ", Year: " + getPublicationYear() +
                ", Available: " + (isAvailable() ? "Yes" : "No"));
    }
}


