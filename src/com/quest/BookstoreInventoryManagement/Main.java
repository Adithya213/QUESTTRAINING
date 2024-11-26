package com.quest.BookstoreInventoryManagement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array containing 5 book objects
        Book[] books = {
                new Book("The Alchemist", "Paulo Coelho", 300.0, 10),
                new SpecialEditionBook("Harry Potter", "J.K. Rowling", 500.0, 5, "Illustrated Edition"),
                new Book("1984", "George Orwell", 250.0, 15),
                new Book("Sapiens", "Yuval Noah Harari", 400.0, 8),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 350.0, 12)
        };

        System.out.println("Bookstore Inventory:");
        displayAllBooks(books);        // Display all books

        int bookIndex = getValidInput(scanner, "Enter the index of the book you want to purchase (1-5): ", 1, books.length) - 1;
        int quantity = getValidInput(scanner, "Enter the quantity to purchase: ", 1, Integer.MAX_VALUE);

        //  purchase the book
        try {
            books[bookIndex].purchase(quantity); // Call purchase() with specific book object
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        double priceThreshold = getValidInput(scanner, "Enter the price threshold to filter books: ", 0, Double.MAX_VALUE);
        System.out.println("\nBooks priced above " + priceThreshold + ":");
        displayBooksAbovePrice(books, priceThreshold);
        System.out.println("\nDiscount Percentage for all books: " + Book.DISCOUNT_PERCENTAGE + "%");
        scanner.close();
    }

    // method to display details of all books
    private static void displayAllBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book); // calls toString()
        }
    }

    //method to display books priced above a given value
    private static void displayBooksAbovePrice(Book[] books, double priceThreshold) {
        for (Book book : books) {
            if (book.getPrice() > priceThreshold) { // Check if price is above the threshold
                System.out.println(book.getTitle()); // Display the title
            }
        }
    }

    // method for input validation (for integers)
    private static int getValidInput(Scanner scanner, String prompt, int min, int max) {
        int input = -1;
        while (input < min || input > max) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                if (input < min || input > max) {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return input;
    }

    // Overloaded method for handling double values
    private static double getValidInput(Scanner scanner, String prompt, double min, double max) {
        double input = -1;
        while (input < min || input > max) {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                if (input < min || input > max) {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return input;
    }
}
