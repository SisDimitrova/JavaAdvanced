package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {
            int firstCard = firstSet.iterator().next();// взима първата карта и приключва
            firstSet.remove(firstCard);
            int secondCard = secondSet.iterator().next();
            secondSet.remove(secondCard);

            if (firstCard > secondCard) {
                firstSet.add(firstCard);
                firstSet.add(secondCard);
            } else if (secondCard > firstCard) {
                secondSet.add(firstCard);
                secondSet.add(secondCard);
            }
            if (firstSet.isEmpty() || secondSet.isEmpty()) {
                break;
            }
        }
        if (firstSet.size() > secondSet.size()) {
            System.out.println("First player win!");
        } else if (secondSet.size() > firstSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
