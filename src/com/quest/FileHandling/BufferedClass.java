package com.quest.FileHandling;

import java.io.*;

public class BufferedClass {
    public static void main(String[] args) {
        try {
            // Initialize BufferedInputStream to read the file
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("File5.txt"));
            // Initialize BufferedOutputStream to write to the destination file
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("destination.txt"));

            byte[] buf = new byte[1024];
            int c;
            // Read and write chunks of the file until end of stream
            while((c = bis.read(buf)) != -1) {
                // Write the chunk of data to the destination file
                bos.write(buf, 0, c);
            }

            // Close the streams
            bis.close();
            bos.close();

            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
