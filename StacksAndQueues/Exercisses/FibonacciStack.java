package ExercissesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class FibonacciStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());

        Deque<Long> stack = new ArrayDeque<>();
        stack.push(0l);
        stack.push(1l);

        if (n < 2) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();
            stack.push(num1);
            stack.push(num1 + num2);
        }
    }
}
