package com.quest.LibraryModified;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library(10, 5);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===========Welcome------------------------------");
            System.out.println("1. Add Book\t\t\t\t2. Add Member");
            System.out.println("3. Display All Books\t4. Display All Members");
            System.out.println("5. Borrow Book\t\t\t6. Return Book");
            System.out.println("7. Exit Library System");
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
                    System.out.println("-----Thank you. Visit Again!-----");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

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

    private static void addMember() {
        scanner.nextLine();
        System.out.println("Enter member details:");
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();

        LibraryMember member = new LibraryMember(memberId, name, contactInfo);
        library.addMember(member);
    }

    private static void borrowBook() {
        scanner.nextLine();
        System.out.print("\nEnter the ISBN of the book to borrow: ");
        String borrowISBN = scanner.nextLine();
        Book bookToBorrow = library.searchBook(borrowISBN);

        System.out.print("Enter the Member ID: ");
        String memberId = scanner.nextLine();
        LibraryMember member = library.getMemberById(memberId);

        if (bookToBorrow != null && member != null) {
            if (library.borrowBook(member, bookToBorrow)) {
                System.out.println("\nBook successfully borrowed!");
            } else {
                System.out.println("Unable to borrow the book.");
            }
        } else {
            System.out.println("Invalid ISBN or Member ID.");
        }
    }

    private static void returnBook() {
        scanner.nextLine();
        System.out.print("\nEnter the ISBN of the book to return: ");
        String returnISBN = scanner.nextLine();
        Book bookToReturn = library.searchBook(returnISBN);
        System.out.print("Enter the Member ID: ");
        String memberId = scanner.nextLine();

        LibraryMember member = library.getMemberById(memberId);

        if (bookToReturn != null && member != null) {
            if (library.returnBook(member, bookToReturn)) {
                System.out.println("\nBook successfully returned!");
            } else {
                System.out.println("Unable to return the book.");
            }
        } else {
            System.out.println("Invalid ISBN or Member ID.");
        }
    }
}
