package com.quest.FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        File file = new File("abc1.txt");

     /*   if(file.createNewFile()) {//to creste a new file
            if(file.exists()){ // to check file exist or not
                System.out.println("File exists "+file.getName());
                System.out.println("File exists"+file.getAbsolutePath());
            }else {
                System.out.println("File not exists");
            }
       */
        // to print only 1 line
//        Scanner scanner = new Scanner(file);
//        scanner.hasNextLine();
//        String line = scanner.nextLine();
//        System.out.println(line);

        //read entire the data present in the file
//        Scanner scanner = new Scanner(file);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            System.out.println(line);

        //delete a file the try to read it
        //file.delete();
        try {
            System.out.println("try started");
            if (file.createNewFile() || file.exists()) {
                Scanner sc = new Scanner(file);
                while (sc.hasNext()) {
                    System.out.println(sc.nextLine());
                }
                sc.close();
                System.out.println("file successfully created");
            } else {
                System.out.println("No such file");
            }
            System.out.println("try ended");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("inside finnally");
            file.delete();
            System.out.println("file successfully deleted");
        }
    }

}
