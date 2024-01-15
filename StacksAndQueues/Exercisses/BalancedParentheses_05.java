package ExercissesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();
        boolean isBalanced = true;

        Deque<Character> opening = new ArrayDeque<>();

        for (int i = 0; i < parentheses.length(); i++) {
            char currentParentheses = parentheses.charAt(i);

            if (currentParentheses == '(' || currentParentheses == '[' || currentParentheses == '{') {
                opening.push(currentParentheses);
            } else {
                if (opening.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpening = opening.pop();
                if (currentParentheses == '}' && lastOpening != '{') {
                    isBalanced = false;
                    break;
                } else if (currentParentheses == ')' && lastOpening != '(') {
                    isBalanced = false;
                    break;
                } else if (currentParentheses == ']' && lastOpening != '[') {
                    isBalanced = false;
                    break;
                }

            }
        }
        if (isBalanced && opening.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}