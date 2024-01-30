package ExercissesStreamFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles_07 {
    public static void main(String[] args)  {

        Path input1 = Paths.get("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path input2 = Paths.get("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        Path output = Paths.get("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");
        try {
            List<String> firstFile = Files.readAllLines(input1);
            List<String> secondFile = Files.readAllLines(input2);

            Files.write(output, firstFile, StandardOpenOption.APPEND);
            Files.write(output, secondFile, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
    }

    }
}
