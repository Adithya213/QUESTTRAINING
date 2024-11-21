package com.quest.LibraryModified;

public class Library implements LibraryOperations {
    private Book[] books;
    private LibraryMember[] members;
    private int bookCount;
    private int memberCount;

    public Library(int maxBooks, int maxMembers) {
        books = new Book[maxBooks];
        members = new LibraryMember[maxMembers];
        bookCount = 0;
        memberCount = 0;
    }

    @Override
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    @Override
    public void addMember(LibraryMember member) {
        if (memberCount < members.length) {
            members[memberCount++] = member;
        } else {
            System.out.println("Max Library members reached!");
        }
    }

    @Override
    public Book searchBook(String searchTerm) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getISBN().equals(searchTerm) ||
                    books[i].getTitle().equalsIgnoreCase(searchTerm) ||
                    books[i].getAuthor().equalsIgnoreCase(searchTerm)) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public boolean borrowBook(LibraryMember member, Book book) {
        return member.borrowBook(book);
    }

    @Override
    public boolean returnBook(LibraryMember member, Book book) {
        return member.returnBook(book);
    }

    @Override
    public void displayAvailableBooks() {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                books[i].displayDetails();
            }
        }
    }

    @Override
    public void displayAllMembers() {
        for (int i = 0; i < memberCount; i++) {
            members[i].displayMemberDetails();
        }
    }

    public LibraryMember getMemberById(String memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;
    }
}

