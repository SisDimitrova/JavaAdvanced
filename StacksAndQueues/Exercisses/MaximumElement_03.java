package ExercissesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maxElement = Collections.max(stack);
                    System.out.println(maxElement);
                    break;
            }

        }
    }
}
