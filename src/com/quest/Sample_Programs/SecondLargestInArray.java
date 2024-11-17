package com.quest.Sample_Programs;

 import java.util.Arrays;

    public class SecondLargestInArray{
        public static void main(String[] args) {
            int[] ar = {9, 4, 5, 7, 8 ,10,10};
            Arrays.sort(ar);
            for(int i= ar.length-1;i>0;i--){
                if(ar[i]>ar[i-1]){
                    System.out.println(ar[i-1]);
                    break;
                }
            }
        }
    }

