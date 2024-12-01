package com.quest.FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Stream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("abc.txt");
            System.out.println("file created successfully");
            int c;
            String str = "input as streams";
            FileOutputStream fos = new FileOutputStream("abc.txt");

            //System.out.println(fis.read()); // when reading it read as hexadecimak

//            while ((c = fis.read()) != -1) {
//                System.out.print((char) c);
//            }
            fos.write(str.getBytes());

            fos.close();
            System.out.println("file stream is closed successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
