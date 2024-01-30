package ExercissesFunctionalPrograming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> function = arr -> {
            int min = Integer.MAX_VALUE;
            for (int num : arr) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        };
        int min = function.apply(number);
        System.out.println(min);
    }
}
