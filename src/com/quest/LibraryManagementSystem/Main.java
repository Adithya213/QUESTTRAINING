package com.quest.LibraryManagementSystem;

import java.util.Scanner;

public class Main {
   static Scanner scanner = new Scanner(System.in);
    static Library library = new Library(10, 5);//max book and member

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Display All Books");
            System.out.println("4. Display All Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    library.displayAvailableBooks();
                    break;
                case 4:
                    library.displayAllMembers();
                    break;
                case 5:
                    borrowBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    System.out.println("-----ThankYou.Visit Again------");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    // Method to add a book to the library
    private static void addBook() {
        scanner.nextLine();
        System.out.println("Enter book details (Fiction/NonFiction): ");
        String type = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Publication Year: ");
        int year = scanner.nextInt();

        if (type.equalsIgnoreCase("Fiction")) {
            FictionBook book = new FictionBook(ISBN, title, author, year);
            library.addBook(book);
        } else if (type.equalsIgnoreCase("NonFiction")) {
            NonFictionBook book = new NonFictionBook(ISBN, title, author, year);
            library.addBook(book);
        }
    }

    // Method to add a member to the library
    private static void addMember() {
        scanner.nextLine();
        System.out.println("Enter member details:");
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();

        LibraryMember member = new LibraryMember(memberId, name, contactInfo); //creating obj for L-member class
        library.addMember(member);
    }

    // Method to borrow a book
    private static void borrowBook() {
        scanner.nextLine();
        System.out.print("\nEnter the ISBN of the book to borrow: ");
        String borrowISBN = scanner.nextLine();
        Book bookToBorrow = library.searchBook(borrowISBN);//calling to search book

        System.out.print("Enter the Member ID: ");
        String memberId = scanner.nextLine();
        LibraryMember member = library.getMemberById(memberId); // Get the member by ID

        if (bookToBorrow != null && member != null) {//borrow
            if (library.borrowBook(member, bookToBorrow)) { //pass member and book obj
                System.out.println("\nBook successfully borrowed!");
            } else {
                System.out.println("Unable to borrow the book (either book is not available or member has reached limit).");
            }
        } else {
            System.out.println("Invalid ISBN or Member ID.");
        }
        library.displayAvailableBooks();// Display available books after borrowing
    }

    // Method to return a book
    private static void returnBook() {
        scanner.nextLine();
        System.out.print("\nEnter the ISBN of the book to return: ");
        String returnISBN = scanner.nextLine();
        Book bookToReturn = library.searchBook(returnISBN);
        System.out.print("Enter the Member ID: ");
        String memberId = scanner.nextLine();

        LibraryMember member = library.getMemberById(memberId);

        if (bookToReturn != null && member != null) {//return
            if (library.returnBook(member, bookToReturn)) { //passes mem and book obj
                System.out.println("\nBook successfully returned!");
            } else {
                System.out.println("Unable to return the book (either the member did not borrow this book or there was an issue).");
            }
        } else {
            System.out.println("Invalid ISBN or Member ID.");
        }
        library.displayAvailableBooks();        // Display available books after returning
    }

}
