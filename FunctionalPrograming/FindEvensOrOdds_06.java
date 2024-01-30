package FunctionalPrograming;


import java.util.Arrays;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

import java.util.stream.IntStream;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        Function<String, IntPredicate> filterFactory = a ->
                "odd".equals(a) ?
                        n -> n % 2 != 0 :
                        n -> n % 2 == 0;
        IntPredicate intPredicate = filterFactory.apply(command);
        IntConsumer intConsumer = n -> System.out.print(n + " ");

                 IntStream.range(bounds[0], bounds[1] + 1)
                        .filter(intPredicate)
                        .forEach(intConsumer);

    }
}
