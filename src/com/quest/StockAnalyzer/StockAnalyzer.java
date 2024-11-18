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
    //highest stock price
    abstract int findMaxPrice();
    //lowest stock price
    abstract int findMinPrice();
    //avg stock price
    abstract double calculateAveragePrice();

    abstract int[] findLongestIncreasingTrend();
    //to display the stock analysisresult
    abstract void displayAnalysis();
}