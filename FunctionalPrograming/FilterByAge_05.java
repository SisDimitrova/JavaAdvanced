package FunctionalPrograming;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] mapData = scanner.nextLine().split(",\\s+");
            people.put(mapData[0], Integer.parseInt(mapData[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate;

        if (condition.equals("younger")) {
            filterPredicate = (personAge, ages) -> personAge <= ages;
        } else {
             filterPredicate = (personAge, ages) -> personAge >= ages;
        }
        Consumer<Map.Entry<String, Integer>> printFormat;
        if (format.equals("age")) {
            printFormat = person -> System.out.println(person.getValue());
        } else if (format.equals("name")) {
            printFormat = person -> System.out.println(person.getKey());
        } else {
            printFormat = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }

        people.entrySet().stream()
                .filter(person -> filterPredicate.test(person.getValue(), age))
                .forEach(printFormat);
    }
}
