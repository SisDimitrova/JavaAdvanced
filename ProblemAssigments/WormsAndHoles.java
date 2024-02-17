package ProblemAssignments;

import java.util.*;

public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> wormsStack = new ArrayDeque<>();
        Deque<Integer> holesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(wormsStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(holesQueue::offer);

        int matches = 0;
        int wormSize = wormsStack.size();

        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {
            if (wormsStack.peek() == holesQueue.peek()) {
                wormsStack.pop();
                holesQueue.poll();
                matches++;
            } else {
                int lastValueWorm = wormsStack.pop() - 3;
                if (lastValueWorm > 0) {
                  wormsStack.push(lastValueWorm);
                }
                holesQueue.poll();
            }
        }
        if (matches == 0) {
            System.out.println("There are no matches.");
        } else {
            System.out.printf("Matches: %d%n", matches);
        }
        if (wormsStack.isEmpty()) {
            if (matches == wormSize) {
                System.out.println("Every worm found a suitable hole!");
            } else {
                System.out.println("Worms left: none");
            }
        } else {
            StringBuilder sb = new StringBuilder();
            List<Integer> leftWorms = new ArrayList<>();

            while (!wormsStack.isEmpty()) {
                leftWorms.add(0, wormsStack.pop());
            }
            for (int i = 0; i < leftWorms.size() - 1; i++) {
                sb.append(leftWorms.get(i));
                sb.append(", ");
            }
            sb.append(leftWorms.get(leftWorms.size() - 1));
            System.out.printf("Worms left: %s%n", sb);
        }
        if (holesQueue.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            while (!holesQueue.isEmpty()) {
                stringBuilder.append(holesQueue.poll());
                if (!holesQueue.isEmpty()) {
                    stringBuilder.append(", ");
                }
            }
            System.out.printf("Holes left: %s%n", stringBuilder);
        }

    }
}
