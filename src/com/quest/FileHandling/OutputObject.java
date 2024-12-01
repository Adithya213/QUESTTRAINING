package com.quest.FileHandling;

import java.io.*;

public class OutputObject {
    public static void main(String[] args) {
        String s1="Added Content";
        try {
            BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream("file4.txt",true));
            bos.write(s1.getBytes());
            System.out.println("Buffer data added successfully");

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file4.txt"));
            int c;
            while((c = bis.read()) != -1){
                System.out.println((char)c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
