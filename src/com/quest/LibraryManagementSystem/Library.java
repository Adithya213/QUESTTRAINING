package com.quest.LibraryManagementSystem;

public class Library {
    private Book[] books;  //to store obj of fic/nonfic
    private LibraryMember[] members;
    private int bookCount;
    private int memberCount;

    public Library(int maxBooks, int maxMembers) {
        books = new Book[maxBooks]; //creating arr of type book(initialization)
        members = new LibraryMember[maxMembers];
        bookCount = 0;
        memberCount = 0;
    }

    // Add a new book
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book; //add book in arr
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    // Add a new library member
    public void addMember(LibraryMember member) {
        if (memberCount < members.length) {
            members[memberCount++] = member; // add mem to array
        } else {
            System.out.println("Max LIbrary member reached!");
        }
    }

    // Search for a book by ISBN,title,author
    public Book searchBook(String searchTerm) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getISBN().equals(searchTerm) ||
                    books[i].getTitle().equalsIgnoreCase(searchTerm) ||
                    books[i].getAuthor().equalsIgnoreCase(searchTerm)) {
                return books[i];
            }
        }
        return null;  // Book not found
    }

    // Borrow a book
    public boolean borrowBook(LibraryMember member, Book book) {
        return member.borrowBook(book);
    }
    // Return a book
    public boolean returnBook(LibraryMember member, Book book) {
        return member.returnBook(book);
    }

    // Display available books
    public void displayAvailableBooks() { //disp available books
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                books[i].displayDetails();
            }
        }
    }

    // Display all members
    public void displayAllMembers() {
        for (int i = 0; i < memberCount; i++) {
            members[i].displayMemberDetails(); // calling
        }
    }

    public LibraryMember getMemberById(String memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;  // Member not found
    }

}

