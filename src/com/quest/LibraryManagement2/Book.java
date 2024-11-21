package com.quest.LibraryManagement2;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
        } else {
            System.out.println("Book already borrowed: " + title);
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
        } else {
            System.out.println("Book is not currently borrowed: " + title);
        }
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", ISBN=" + ISBN + ", Borrowed=" + isBorrowed + "]";
    }
}

