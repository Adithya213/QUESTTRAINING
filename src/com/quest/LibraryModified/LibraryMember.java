package com.quest.LibraryModified;


public class LibraryMember implements LibraryMemberOperations {
    private String memberId;
    private String name;
    private String contactInfo;
    private String[] borrowedBooks;
    private int borrowedCount;

    public LibraryMember(String memberId, String name, String contactInfo) {
        this.memberId = memberId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new String[5];
        this.borrowedCount = 0;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    @Override
    public boolean borrowBook(Book book) {
        if (borrowedCount < 5 && book.isAvailable()) {
            borrowedBooks[borrowedCount++] = book.getISBN();
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBook(Book book) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i].equals(book.getISBN())) {
                borrowedBooks[i] = null;
                book.setAvailable(true);
                borrowedCount--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayMemberDetails() {
        System.out.println("Member ID: " + memberId + ", Name: " + name + ", Contact: " + contactInfo);
        System.out.println("Borrowed Books: ");
        for (int i = 0; i < borrowedCount; i++) {
            System.out.println("- " + borrowedBooks[i]);
        }
    }
}

