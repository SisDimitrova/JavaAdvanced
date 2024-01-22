package SetsAndMaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestTreeNumbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        numbers.stream().limit(3).forEach(integer -> System.out.printf("%d ", integer));
    }
}
