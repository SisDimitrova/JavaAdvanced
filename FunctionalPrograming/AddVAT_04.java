package FunctionalPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVAT = value -> value * 1.2;
        Consumer<Double> printer = aDouble -> System.out.printf("%.2f%n", aDouble);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Double::parseDouble)
                .map(addVAT)
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        numbers.forEach(printer);
    }
}
