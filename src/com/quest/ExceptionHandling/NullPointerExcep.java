package com.quest.ExceptionHandling;

public class NullPointerExcep {
    public static void main(String[] args) {
        String s=null;
       // int i =null;//null will acceptable for string(non primitive). ie null is not for primitive
        try {
            System.out.println(" String is " + s.length());
        }catch(NullPointerException e) {
            //System.out.println("NullPointerException caught"+e.getLocalizedMessage());
            //System.out.println("NullPointerException caught"+e.getMessage());
             e.printStackTrace();
        }//
    }
}
