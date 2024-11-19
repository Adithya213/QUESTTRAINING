package com.quest.LibraryManagementSystem;

public abstract class Book {  //encapsulation
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    // Constructor
    public Book(String ISBN, String title, String author, int publicationYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    //getter()
    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
   //method tocheck book availability
    public boolean isAvailable() {
        return isAvailable;
    }
    //setter()
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // method displaying details
    public abstract void displayDetails();
}

