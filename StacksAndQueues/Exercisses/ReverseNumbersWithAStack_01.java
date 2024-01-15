package ExercissesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String[] num = scanner.nextLine().split("\\s+");

        for (String number : num) {
            stack.push(number);
        }
        while (!stack.isEmpty()) {
            System.out.printf("%s ", stack.pop());
        }
    }
}
