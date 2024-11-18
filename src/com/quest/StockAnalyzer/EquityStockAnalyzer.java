package com.quest.StockAnalyzer;

class EquityStockAnalyzer extends StockAnalyzer {
    String sector;

    public EquityStockAnalyzer(String stockName, String stockSymbol, String sector, int[] prices) {
        super(stockName, stockSymbol, prices);//super calling stt
        this.sector = sector;
    }

    @Override
    int findMaxPrice() {
        int max = prices[0]; //initialized max with 1st price
        for (int price : prices) {
            if (price > max)
                max = price;
        }
        return max;
    }

    @Override
    int findMinPrice() {
        int min = prices[0];
        for (int price : prices) {
            if (price < min)
                min = price;
        }
        return min;
    }

    @Override
    double calculateAveragePrice() {
        int sum = 0;
        for (int price : prices) {
            sum += price; //calculating the sum
        }
        return (double) sum / prices.length; // int to double
    }

    @Override
    int[] findLongestIncreasingTrend() {
        int maxLength = 0, start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                if (i - tempStart + 1 > maxLength) {
                    maxLength = i - tempStart + 1;
                    start = tempStart;
                    end = i;
                }
            } else {
                tempStart = i;
            }
        }
        return new int[]{start + 1, end + 1, maxLength};//start day,end day,length of trend
    }

    @Override
    void displayAnalysis() {
        System.out.println("Analysis for Equity Stock:");
        System.out.println("Stock Name: " + stockName);
        System.out.println("Stock Symbol: " + stockSymbol);
        System.out.println("Sector: " + sector);
        System.out.println("Highest Price: " + findMaxPrice());
        System.out.println("Lowest Price: " + findMinPrice());
        System.out.println("Average Price: " + calculateAveragePrice());
        int[] trend = findLongestIncreasingTrend(); //calling
        System.out.println("Longest Increasing Trend: Start Day "+trend[0]+", End Day " +trend[1]+", Length: "+trend[2]+" days");
    }
}