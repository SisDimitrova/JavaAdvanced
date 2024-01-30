package ExercissesFunctionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> indexMinNumber = list -> {
            int min = Integer.MAX_VALUE;
            int idx = -1;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= min) {
                    min = list.get(i);
                    idx = i;
                }
            }
            return idx;
        };

        System.out.println(indexMinNumber.apply(numbers));
    }
}
