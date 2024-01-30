package ExercissesStreamFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes_02 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"))) {
            long sum = 0;
            String line = bufferedReader.readLine();
            while (line != null) {
                char[] charactersFromLine = line.toCharArray();
                for (char symbol : charactersFromLine) {
                    sum+= symbol;
                }
                line = bufferedReader.readLine();
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

