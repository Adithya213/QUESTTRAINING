package com.quest.LibraryModified;

public class NonFictionBook extends Book {

    public NonFictionBook(String ISBN, String title, String author, int publicationYear) {
        super(ISBN, title, author, publicationYear);
    }

    @Override
    public void displayDetails() {
        System.out.println("Non-Fiction Book - ISBN: " + getISBN() + ", Title: " + getTitle() +
                ", Author: " + getAuthor() + ", Year: " + getPublicationYear() +
                ", Available: " + (isAvailable() ? "Yes" : "No"));
    }
}

