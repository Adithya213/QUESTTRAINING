package com.quest.StockAnalyzer;

import java.util.InputMismatchException;
import java.util.Scanner;

    public class MainClass {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter details for Equity Stock:");
            System.out.print("Stock Name: ");
            String equityName = scanner.nextLine();
            System.out.print("Stock Symbol: ");
            String equitySymbol = scanner.nextLine();
            System.out.print("Sector: ");
            String sector = scanner.nextLine();
            System.out.print("Number of days: ");
            int noDays = scanner.nextInt();
            int[] equityPrices = new int[noDays];
            System.out.println("Enter prices: ");
            for (int i = 0; i < noDays; i++) {
                equityPrices[i] = scanner.nextInt();
            }

            scanner.nextLine();
            System.out.println("\nEnter details for Commodity Stock:");
            System.out.print("Stock Name: ");
            String commodityName = scanner.nextLine();
            System.out.print("Stock Symbol: ");
            String commoditySymbol = scanner.nextLine();
            System.out.print("Commodity Type: ");
            String commodityType = scanner.nextLine();
            System.out.print("Number of days: ");
            noDays = scanner.nextInt();
            int[] commodityPrices = new int[noDays];
            System.out.println("Enter prices: ");
            for (int i = 0; i < noDays; i++) {
                commodityPrices[i] = scanner.nextInt();
            }

            // Creating objects - upcasting
            StockAnalyzer equityStock = new EquityStockAnalyzer(equityName, equitySymbol, sector, equityPrices);
            StockAnalyzer commodityStock = new CommodityStockAnalyzer(commodityName, commoditySymbol, commodityType, commodityPrices);

            // Display analysis
            System.out.println("\n--- Stock Analysis ---");
            equityStock.displayAnalysis();
            commodityStock.displayAnalysis();

            // Compare stocks
            double avgEquity = equityStock.calculateAveragePrice();//calling
            double avgCommodity = commodityStock.calculateAveragePrice();
            System.out.println("\nComparison Results:");
            if (avgEquity > avgCommodity) {
                System.out.println("Stock with Highest Average Price: Equity Stock " +equityName+"with Average Price: "+avgEquity);
            } else {
                System.out.println("Stock with Highest Average Price: Commodity Stock "+commodityName+" with Average Price: "+avgCommodity);
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

        }
    }