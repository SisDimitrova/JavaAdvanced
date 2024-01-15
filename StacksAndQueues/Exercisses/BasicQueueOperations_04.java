package ExercissesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        Deque<Integer> queue = new ArrayDeque<>();
        String[] line = scanner.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(line[i]));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(x)) {
            System.out.println(true);
        } else {
            int minElement = Collections.min(queue);
            System.out.println(minElement);
        }
    }
}
