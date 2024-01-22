package StreamsFilesAndDirectories;

import java.io.File;

public class ListFiles_07 {
    public static void main(String[] args) {
        File file = new File("C:\\Softuni SISE\\JavaAdvanced\\src\\resurce\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
              File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
