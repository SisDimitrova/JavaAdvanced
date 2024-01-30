package FunctionalPrograming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumber_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> number = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> evenNumbers = number.stream()
                .filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println(evenNumbers.toString().replaceAll("\\[|]", ""));
        Collections.sort(evenNumbers);
        System.out.println(evenNumbers.toString().replaceAll("\\[|]", ""));
    }
}
