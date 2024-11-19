package com.quest.LibraryManagementSystem;

public class FictionBook extends Book {  //inheritance

    public FictionBook(String ISBN, String title, String author, int publicationYear) {
        super(ISBN, title, author, publicationYear);
    }

    @Override
    public void displayDetails() {
        System.out.println("Fiction Book - ISBN: "+getISBN()+", Title: "+getTitle() + ", Author: "+getAuthor() +
                ", Year: " + getPublicationYear() + ", Available: " + (isAvailable() ? "Yes" : "No"));
    }
}

