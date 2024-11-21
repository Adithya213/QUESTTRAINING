package com.quest.StockAnalyzer;

abstract class StockAnalyzer {
    String stockName;
    String stockSymbol;
    int[] prices;//to store stock price for multiple days

    public StockAnalyzer(String stockName, String stockSymbol, int[] prices) {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
        this.prices = prices;
    }

    abstract int findMaxPrice();

    abstract int findMinPrice();

    abstract double calculateAveragePrice();

    abstract int[] findLongestIncreasingTrend();

    abstract void displayAnalysis();
}