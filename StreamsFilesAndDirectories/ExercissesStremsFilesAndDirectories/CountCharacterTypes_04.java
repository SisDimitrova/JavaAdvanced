package ExercissesStreamFilesAndDirectories;

import java.io.*;

public class CountCharacterTypes_04 {
    public static void main(String[] args) {

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (FileReader fr = new FileReader("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
             PrintWriter pw = new PrintWriter(new FileWriter("C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output1.txt"))) {
            int symbol = (char) fr.read();
            while (symbol >= 0) {
                char character = (char) symbol;
                if (isVowel(character)) {
                   vowels++;
                } else if (isPunctuation(character)) {
                    punctuation++;
                } else if (!Character.isWhitespace(character)){
                    consonants++;
                }
                symbol = fr.read();
            }
            pw.println("Vowels: " + vowels);
            pw.println("Other symbols: " + consonants);
            pw.println("Punctuation: " + punctuation);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'o' || symbol == 'u' || symbol == 'i' || symbol == 'e';
    }

    public static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }
}