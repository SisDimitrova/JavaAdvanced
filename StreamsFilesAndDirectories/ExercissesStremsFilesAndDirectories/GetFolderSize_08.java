package ExercissesStreamFilesAndDirectories;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {

        File folder = new File("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources");

         int size = 0;
         if (folder.isDirectory()) {
             File[] files = folder.listFiles();
             for (File file : files) {
                 size += file.length();
             }
         }
        System.out.printf("Folder size: %d", size);

    }
}
