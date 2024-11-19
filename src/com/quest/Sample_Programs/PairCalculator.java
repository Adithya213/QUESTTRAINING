package com.quest.Sample_Programs;

public class PairCalculator {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 10, 30, 20, 50, 40, 40, 30, 30, 10,10,10};

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            boolean isCounted = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isCounted = true;
                    break;
                }
            }
            if (!isCounted) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
                System.out.println(arr[i] + "'s - " + (count / 2));
            }
        }
    }
}

