package ExercissesStacksAndQueues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);

        Deque<Integer> stack = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(input[i]));
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(x)) {
            System.out.println(true);
        } else {
            int minElement = Collections.min(stack);
            System.out.println(minElement);
        }
    }
}
