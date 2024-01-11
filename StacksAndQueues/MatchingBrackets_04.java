package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

        String expression = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
           char current = expression.charAt(i);

           if ('(' == current) {
               stack.push(i);
           } else if (')' == current) {
              int startIdx = stack.pop();
              String match = expression.substring(startIdx, i + 1);
               System.out.println(match);

           }
        }
    }
}
