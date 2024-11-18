package com.quest.StockAnalyzer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try { //input Validation
            // Input for Equity Stock
            System.out.println("Enter details for Equity Stock:");
            System.out.print("Stock Name: ");
            String equityName = scanner.nextLine().trim();
            while (equityName.isEmpty()) {
                System.out.print("Stock Name cannot be empty. Please enter again: ");
                equityName = scanner.nextLine().trim();
            }

            System.out.print("Stock Symbol: ");
            String equitySymbol = scanner.nextLine().trim();
            while (equitySymbol.isEmpty()) {
                System.out.print("Stock Symbol cannot be empty. Please enter again: ");
                equitySymbol = scanner.nextLine().trim();
            }

            System.out.print("Sector: ");
            String sector = scanner.nextLine().trim();
            while (sector.isEmpty()) {
                System.out.print("Sector cannot be empty. Please enter again: ");
                sector = scanner.nextLine().trim();
            }

            int n = 0;
            while (n <= 0) {
                try {
                    System.out.print("Number of days: ");
                    n = scanner.nextInt();
                    if (n <= 0) {
                        System.out.println("Number of days must be greater than 0.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a positive integer.");
                    scanner.next(); // Clear invalid input
                }
            }

            int[] equityPrices = new int[n];
            System.out.println("Enter prices (non-negative integers): ");
            for (int i = 0; i < n; i++) {
                while (true) {
                    try {
                        System.out.print("Price for day " + (i + 1) + ": ");
                        int price = scanner.nextInt();
                        if (price < 0) {
                            System.out.println("Price cannot be negative. Try again.");
                        } else {
                            equityPrices[i] = price;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a non-negative integer.");
                        scanner.next(); // Clear invalid input
                    }
                }
            }scanner.nextLine();

            // Input for Commodity Stock
            System.out.println("\nEnter details for Commodity Stock:");
            System.out.print("Stock Name: ");
            String commodityName = scanner.nextLine().trim();
            while (commodityName.isEmpty()) {
                System.out.print("Stock Name cannot be empty. Please enter again: ");
                commodityName = scanner.nextLine().trim();
            }

            System.out.print("Stock Symbol: ");
            String commoditySymbol = scanner.nextLine().trim();
            while (commoditySymbol.isEmpty()) {
                System.out.print("Stock Symbol cannot be empty. Please enter again: ");
                commoditySymbol = scanner.nextLine().trim();
            }

            System.out.print("Commodity Type: ");
            String commodityType = scanner.nextLine().trim();
            while (commodityType.isEmpty()) {
                System.out.print("Commodity Type cannot be empty. Please enter again: ");
                commodityType = scanner.nextLine().trim();
            }

            n = 0;
            while (n <= 0) {
                try {
                    System.out.print("Number of days: ");
                    n = scanner.nextInt();
                    if (n <= 0) {
                        System.out.println("Number of days must be greater than 0.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a positive integer.");
                    scanner.next(); // Clear invalid input
                }
            }

            int[] commodityPrices = new int[n];
            System.out.println("Enter prices (non-negative integers): ");
            for (int i = 0; i < n; i++) {
                while (true) {
                    try {
                        System.out.print("Price for day " + (i + 1) + ": ");
                        int price = scanner.nextInt();
                        if (price < 0) {
                            System.out.println("Price cannot be negative. Try again.");
                        } else {
                            commodityPrices[i] = price;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a non-negative integer.");
                        scanner.next(); // Clear invalid input
                    }
                }
            }

            // Create objects for parent - upcasting
            StockAnalyzer equityStock = new EquityStockAnalyzer(equityName, equitySymbol, sector, equityPrices);
            StockAnalyzer commodityStock = new CommodityStockAnalyzer(commodityName, commoditySymbol, commodityType, commodityPrices);

            // Display analysis
            System.out.println("\n--- Stock Analysis ---");
            equityStock.displayAnalysis();
            commodityStock.displayAnalysis();

            // Compare stocks
            double avgEquity = equityStock.calculateAveragePrice();
            double avgCommodity = commodityStock.calculateAveragePrice();
            System.out.println("\nComparison Results:");
            if (avgEquity > avgCommodity) {
                System.out.println("Stock with Highest Average Price: Equity Stock - " + equityName + " with Average Price: " + avgEquity);
            } else {
                System.out.println("Stock with Highest Average Price: Commodity Stock - " + commodityName + " with Average Price: " + avgCommodity);
            }

            int[] equityTrend = equityStock.findLongestIncreasingTrend();
            int[] commodityTrend = commodityStock.findLongestIncreasingTrend();
            if (equityTrend[2] > commodityTrend[2]) {
                System.out.println("Stock with Longest Increasing Trend: Equity Stock - " + equityName + " with a trend length of " + equityTrend[2] + " days");
            } else if (commodityTrend[2] > equityTrend[2]) {
                System.out.println("Stock with Longest Increasing Trend: Commodity Stock - " + commodityName + " with a trend length of " + commodityTrend[2] + " days");
            } else {
                System.out.println("Stock with Longest Increasing Trend: Both " + equityName + " and " + commodityName + " with a trend length of " + equityTrend[2] + " days");
            }

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

}
