package com.quest.FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandling2 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("abc1.txt");
            fileWriter.write("Hello World - this is file writer example");//adding content
            fileWriter.append("\nthis is the 2nd line\n");
            fileWriter.append("12345",0,4);
            fileWriter.close(); //close the filewriter stream
            System.out.println("file successfully created and added content!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
