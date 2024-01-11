package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String line = scanner.nextLine();
        while (!line.equals("Home")) {
            if (!line.equals("back")) {
                stack.push(line);
                System.out.println(line);
            } else {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }


            line = scanner.nextLine();
        }




    }
}
