package ExercissesFunctionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = numbers -> numbers.stream().map(number -> number + 1)
                .collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numbers -> numbers.stream().map(number -> number * 2)
                .collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numbers -> numbers.stream().map(number -> number - 1)
                .collect(Collectors.toList());


        while (true) {
            String command = scanner.nextLine();
            if ("end".equals(command)) {
                break;
            }
            switch (command) {
                case "add":
                 num = add.apply(num);
                break;
                case "multiply":
                    num = multiply.apply(num);
                    break;
                case "subtract":
                    num = subtract.apply(num);
                    break;
                case "print":
                    num.forEach(number -> System.out.print(number + " "));
                    System.out.println();
                        break;
            }
        }
    }
}
