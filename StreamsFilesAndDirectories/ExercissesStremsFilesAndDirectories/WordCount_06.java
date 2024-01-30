package ExercissesStreamFilesAndDirectories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCount_06 {
    public static void main(String[] args) throws FileNotFoundException {

        try (Scanner scan = new Scanner(new FileReader("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        Scanner textScanner = new Scanner(new FileReader("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
             PrintWriter pw = new PrintWriter("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt")){
            LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();
              Arrays.stream(scan.nextLine().split(" ")).forEach(word-> wordMap.put(word, 0));

              while (textScanner.hasNext()) {
                  String textInput = textScanner.next();
                  if (wordMap.containsKey(textInput)) {
                      int currentCount = wordMap.get(textInput);
                      currentCount++;
                      wordMap.put(textInput, currentCount);
                  }
              }
              wordMap.entrySet().forEach(e -> pw.printf("%s - %d%n", e.getKey(), e.getValue()));

        }
    }
}
