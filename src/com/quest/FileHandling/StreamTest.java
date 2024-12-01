package com.quest.FileHandling;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {
    public static void main(String[] args) {
        String filePath = "file5.txt";
        FileOutputStream fos = null;

        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + filePath);
            } else {
                System.out.println("File already exists. ");
            }

            fos = new FileOutputStream(file, true); // 'true' enables appending
            fos.write("Line6\n".getBytes());
            fos.write("Line 7\n".getBytes());
            fos.write("Line 8\n".getBytes());
            fos.write("Line 9\n".getBytes());
            fos.write("Line 10\n".getBytes());
            System.out.println("Additional content written to file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    System.out.println("FileOutputStream closed successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Read content
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            int c;
            System.out.println("Reading content from the file:");
            while ((c = fis.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    System.out.println("FileInputStream closed successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
