package ExercissesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PoisonousPlants_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPlants = Integer.parseInt(scanner.nextLine());
        int[] pesticides = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Deque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);
        int[] days = new int[numOfPlants];

        for (int i = 1; i < numOfPlants; i++) {
            int maxDays = 0;
            while (!indexes.isEmpty() && pesticides[indexes.peek()] >= pesticides[i]) {
                maxDays = Math.max(maxDays, days[indexes.pop()]);
            }
            if (!indexes.isEmpty()) {
                days[i] = maxDays + 1;
            }
            indexes.push(i);
        }

        int max = Arrays.stream(days).max().getAsInt();
        System.out.println(max);
    }
}
