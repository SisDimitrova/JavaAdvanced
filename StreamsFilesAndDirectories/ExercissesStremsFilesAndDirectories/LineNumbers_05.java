package ExercissesStreamFilesAndDirectories;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers_05 {
    public static void main(String[] args) throws FileNotFoundException {

        try (PrintWriter pw = new PrintWriter("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt")){
            Path inputFile = Paths.get("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");

            List<String> lines = Files.readAllLines(inputFile);
            for (int i = 0; i < lines.size(); i++) {
                pw.println((i + 1) + ". " + lines.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
