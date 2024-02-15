package ProblemAssignments;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> tulipsStack = new ArrayDeque<>();
        Deque<Integer> daffodilsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .forEach(daffodilsQueue::offer);

        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt)
                .forEach(tulipsStack::push);

        int bouquets = 0;
        int leftFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int tulip = tulipsStack.peek();
            int daffodil = daffodilsQueue.peek();

            int sum = tulip + daffodil;
            if (sum == 15) {
                bouquets++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (sum > 15) {
                tulipsStack.pop();
                tulipsStack.push(tulip - 2);
            } else if (sum < 15) {
                leftFlowers += sum;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }
        bouquets += leftFlowers / 15;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
