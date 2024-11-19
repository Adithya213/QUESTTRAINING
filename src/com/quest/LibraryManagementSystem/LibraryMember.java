package com.quest.LibraryManagementSystem;

public class LibraryMember {
    private String memberId;
    private String name;
    private String contactInfo;
    private String[] borrowedBooks;  // Array to store borrowed book ISBNs
    private int borrowedCount;

    public LibraryMember(String memberId, String name, String contactInfo) {
        this.memberId = memberId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new String[5]; // max book limitset as 5
        this.borrowedCount = 0;
    }

    // Getters and Setters
    public String getMemberId()
    { return memberId;
    }
    public String getName()
    { return name;
    }


    // Borrow a book
    public boolean borrowBook(Book book) { //passing obj of (fic/Nonfic) to reference of book
        if (borrowedCount < 5 && book.isAvailable()) {
            borrowedBooks[borrowedCount++] = book.getISBN(); // Borrow book by isbn and store in arr
            book.setAvailable(false); // Mark the book as unavailable
            return true;
        }
        return false; // Either max limit or book unavailable
    }

    // Return a book
    public boolean returnBook(Book book) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i].equals(book.getISBN())) { //check the book
                borrowedBooks[i] = null;  // Remove the book from borrowed array
                book.setAvailable(true);  // Mark the book as available
                borrowedCount--;
                return true;
            }
        }
        return false;  // Book not borrowed
    }

    public void displayMemberDetails() { //to get all members
        System.out.println("Member ID: " + memberId + ", Name: " + name + ", Contact: " + contactInfo);
        System.out.println("Borrowed Books: ");
        for (int i = 0; i < borrowedCount; i++) {//also print borrowed or not
            System.out.println("- " + borrowedBooks[i]);
        }
    }
}

