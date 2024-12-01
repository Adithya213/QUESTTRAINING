package com.quest.FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingTest {
    public static void main(String[] args) {
        File file = new File("abc1.txt");
        try {
            System.out.println("try started");
            if (file.exists() || file.createNewFile()) {
                System.out.println("File created successfully--> " + file.getName());

                FileWriter fileWriter = new FileWriter(file, true);//append
                fileWriter.write("1st line\n");
                fileWriter.write("2nd line\n");
                fileWriter.close();
                System.out.println("Data successfully written to " + file.getName());

                Scanner sc = new Scanner(file);//reading
                System.out.println("Reading file content:");
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
                sc.close();
            } else {
                System.out.println("No such file");
            }
            System.out.println("try ended");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Inside finally");
            file.delete();
            System.out.println("File successfully deleted");
        }
    }
}
