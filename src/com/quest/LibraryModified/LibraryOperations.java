package com.quest.LibraryModified;

public interface LibraryOperations {
    void addBook(Book book);
    void addMember(LibraryMember member);
    Book searchBook(String searchTerm);
    boolean borrowBook(LibraryMember member, Book book);
    boolean returnBook(LibraryMember member, Book book);
    void displayAvailableBooks();
    void displayAllMembers();
}

