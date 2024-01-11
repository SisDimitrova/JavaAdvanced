package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();
        String[] tokens = expression.split("\\s+");

          // Collections.addAll(stack, tokens);
        for (int i = tokens.length - 1; i >= 0 ; i--) {
            String token = tokens[i];
            stack.push(token);
        }

        
        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(firstNum + secondNum));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNum - secondNum));
                    break;
            }
        }
        System.out.println(stack.peek());
        
    }
}
