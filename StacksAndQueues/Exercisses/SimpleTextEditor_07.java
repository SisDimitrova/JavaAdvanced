package ExercissesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommand = Integer.parseInt(scanner.nextLine());

        StringBuilder currentText = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < countCommand; i++) {
            String[] parts = scanner.nextLine().split("\\s+");

            int commandNumber =Integer.parseInt(parts[0]);

            switch (commandNumber) {
                case 1:
                    stack.push(currentText.toString());
                    String append = parts[1];
                    currentText.append(append);

                    break;
                case 2:
                    stack.push(currentText.toString());
                    int countDelete = Integer.parseInt(parts[1]);
                    int startIdx = currentText.length() - countDelete;
                    currentText.delete(startIdx, startIdx + countDelete);
                    break;
                case 3:
                    int idx = Integer.parseInt(parts[1]);
                    System.out.println(currentText.charAt(idx - 1));
                    break;
                case 4:
                    if (!stack.isEmpty()) {
                        currentText = new StringBuilder(stack.pop());
                    }
                    break;
            }
        }
    }
}
