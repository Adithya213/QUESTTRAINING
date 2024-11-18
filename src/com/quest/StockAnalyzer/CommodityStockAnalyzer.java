package com.quest.StockAnalyzer;

class CommodityStockAnalyzer extends StockAnalyzer {
    String commodityType;

    public CommodityStockAnalyzer(String stockName, String stockSymbol, String commodityType, int[] prices) {
        super(stockName, stockSymbol, prices);
        this.commodityType = commodityType;
    }

    @Override
    int findMaxPrice() {
        int max = prices[0];
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
            sum += price;
        }
        return (double) sum / prices.length;
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
        return new int[]{start + 1, end + 1, maxLength};
    }

    @Override
    void displayAnalysis() {
        System.out.println("Analysis for Commodity Stock:");
        System.out.println("Stock Name: " + stockName);
        System.out.println("Stock Symbol: " + stockSymbol);
        System.out.println("Commodity Type: " + commodityType);
        System.out.println("Highest Price: " + findMaxPrice());
        System.out.println("Lowest Price: " + findMinPrice());
        System.out.println("Average Price: " + calculateAveragePrice());
        int[] trend = findLongestIncreasingTrend();
        System.out.println("Longest Increasing Trend: Start Day "+trend[0]+", End Day "+trend[1]+", Length: "+trend[2]+" days");
    }
}