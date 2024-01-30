package ExercissesFunctionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endOfRange = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = number -> {
            for (Integer num : numbers) {
                if (number % num != 0) {
                    return  false;
                }

            }
            return true;
        };

        for (int num = 1; num <= endOfRange; num++) {
            if (isDivisible.test(num)) {
                System.out.print(num + " ");
            }
        }
     //   IntStream.rangeClosed(1, endOfRange).boxed().filter(isDivisible).forEach(n -> System.out.print(n + " "));
    }
}
