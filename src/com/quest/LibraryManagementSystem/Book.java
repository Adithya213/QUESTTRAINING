package com.quest.LibraryManagementSystem;

public abstract class Book {
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

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract void displayDetails();
}

