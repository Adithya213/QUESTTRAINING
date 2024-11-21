package com.quest.LibraryModified;
public interface LibraryMemberOperations {
    boolean borrowBook(Book book);
    boolean returnBook(Book book);
    void displayMemberDetails();
}

