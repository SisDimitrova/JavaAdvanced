package ProblemAssignments;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liliesStack = new ArrayDeque<>();
        Deque<Integer> rosesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(liliesStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(rosesQueue::offer);
         int wreath = 0;
         int otherFlowers = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int rose = rosesQueue.poll();
            int lily = liliesStack.pop();

            int sum = lily + rose;

            while (sum > 15) {
                lily -= 2;
                sum = lily + rose;
            }

           if (sum == 15) {
               wreath++;
           } else if (sum < 15) {
             otherFlowers += sum;
           }
        }

        int leftoverWreaths = otherFlowers / 15;
        wreath += leftoverWreaths;

        if (wreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreath);
        }
    }
}
