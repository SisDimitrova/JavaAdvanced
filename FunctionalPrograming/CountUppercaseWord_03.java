package FunctionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWord_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUpperCase = s -> Character.isUpperCase(s.charAt(0));
        Consumer<String> printToConsole = s -> System.out.println(s);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(isUpperCase)
                .collect(Collectors.toList());

        printToConsole.accept(String.valueOf(words.size()));
        words.forEach(printToConsole);

    }
}
