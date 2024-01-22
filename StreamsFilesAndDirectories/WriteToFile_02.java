package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WriteToFile_02 {
    public static void main(String[] args) {

        Character[] chars = {',', '.', '!', '?'};

        Set<Character> pun = new HashSet<>(List.of(chars));

        String inputPath = "C:\\Softuni SISE\\JavaAdvanced\\src\\resurce\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Softuni SISE\\JavaAdvanced\\src\\resurce\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\writeToFile.txt";

        try (FileInputStream fileInputStream = new FileInputStream(inputPath);
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                char ch = (char)oneByte;
                if (!pun.contains(ch)) {
                    fileOutputStream.write(oneByte);
                }

                    oneByte = fileInputStream.read();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
