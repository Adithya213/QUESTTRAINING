package com.quest.LibraryManagement2;

class Member implements LibraryOperations {
    protected String name;
    protected String memberId;
    protected String membershipType;
    protected int borrowedBooks;

    public Member(String name, String memberId, String membershipType) {
        this.name = name;
        this.memberId = memberId;
        this.membershipType = membershipType;
        this.borrowedBooks = 0;
    }

    @Override
    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            book.borrowBook();
            borrowedBooks++;
            System.out.println(name + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Book is already borrowed by someone else.");
        }
    }

    @Override
    public void returnBook(Book book) {
        if (book.isBorrowed()) {
            book.returnBook();
            borrowedBooks--;
            System.out.println(name + " returned the book: " + book.getTitle());
        } else {
            System.out.println("Book is not currently borrowed.");
        }
    }

    public void calculateLateFees(final int daysLate) {
        int lateFeePerDay = 10;
        System.out.println(name + " owes Rs. " + (daysLate * lateFeePerDay) + " as late fees.");
    }

    @Override
    public String toString() {
        return "Member [Name=" + name + ", ID=" + memberId + ", Membership Type=" + membershipType + ", Borrowed Books=" + borrowedBooks + "]";
    }
}

