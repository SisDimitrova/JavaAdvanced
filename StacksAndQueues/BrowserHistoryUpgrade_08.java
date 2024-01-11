package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> browserHistory = new ArrayDeque<>();
        Deque<String> browserNext = new ArrayDeque<>();

        String line = scanner.nextLine();
        while (!"Home".equals(line)) {
            if ("back".equals(line)) {
                if (browserHistory.size() > 1) {
                    browserNext.addFirst(browserHistory.pop());
                    System.out.printf("%s%n", browserHistory.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if ("forward".equals(line)) {
                if (!browserNext.isEmpty()) {
                    browserHistory.push(browserNext.pop());
                    System.out.printf("%s%n", browserHistory.peek());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                browserHistory.push(line);
                browserNext.clear();
                System.out.printf("%s%n", browserHistory.peek());
            }
            line = scanner.nextLine();
        }
    }
}
