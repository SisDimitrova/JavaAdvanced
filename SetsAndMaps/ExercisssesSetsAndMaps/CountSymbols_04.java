package ExercissesSetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<Character, Integer> countSymbols = new TreeMap<>();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (!countSymbols.containsKey(symbol)) {
                countSymbols.put(symbol, 1);
            } else {
                countSymbols.put(symbol, countSymbols.get(symbol) + 1);
            }
        }
        countSymbols.entrySet().forEach(entry -> {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        });


    }
}
