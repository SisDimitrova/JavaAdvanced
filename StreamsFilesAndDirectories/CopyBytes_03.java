package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) {
        String inputPath = "C:\\Softuni SISE\\JavaAdvanced\\src\\resurce\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Softuni SISE\\JavaAdvanced\\src\\resurce\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {

               if (oneByte == 10 || oneByte == 32) {
                   fileOutputStream.write(oneByte);
                   oneByte = fileInputStream.read();
                   continue;
               }
               String data = String.valueOf(oneByte);
               String data1 = String.valueOf((char) oneByte);
                for (char c : data.toCharArray()) {
                    fileOutputStream.write(c);
                }
                oneByte = fileInputStream.read();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
