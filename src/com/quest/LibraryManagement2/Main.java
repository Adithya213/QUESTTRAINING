package com.quest.LibraryManagement2;

// Main Program
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Animal Farm", "George Orwell", "12345");  //adding book
        Book book2 = new Book("War and Peace", "Leo Tolstoy", "67890");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "11223");

        Member member1 = new Member("Leena Thomas", "M001", "Regular");  //adding member
        PremiumMember member2 = new PremiumMember("Adithya k", "PM001");      //adding premium mem

        member1.borrowBook(book1);//calling borrow
        member2.borrowBook(book2);
        member1.borrowBook(book2); // member 2 is already borrowed the book

        member1.returnBook(book1); //calling return
        member2.returnBook(book3); // book 3 is not borrowed

        System.out.println(book1);//displaying book & mem details
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(member1);
        System.out.println(member2);

        // late fees
        member1.calculateLateFees(3);
        member2.calculateLateFees(5);
    }
}

