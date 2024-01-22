package ExercissesSetsAndMaps;

import java.util.*;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

          int[] cuntsSets = Arrays.stream(scanner.nextLine().split("\\s+"))
                  .mapToInt(Integer::parseInt).toArray();

          int firstCount = cuntsSets[0];
          int secondCount = cuntsSets[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 1; i <= firstCount; i++) {
            int numbers = Integer.parseInt(scanner.nextLine());
            firstSet.add(numbers);
        }
        for (int i = 1; i <= secondCount; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }
        firstSet.retainAll(secondSet);

        firstSet.forEach(integer -> {
            System.out.print(integer + " ");
        });
    }
}
