package ProblemAssignments;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> monstersQueue = new ArrayDeque<>();
        Deque<Integer> strikesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(monstersQueue::offer);

        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(strikesStack::push);
        int killedMonster = 0;

        while (!monstersQueue.isEmpty() && !strikesStack.isEmpty()) {
            int monster = monstersQueue.poll();
            int strike = strikesStack.pop();

            if (monster <= strike) {
                killedMonster++;
                strike -= monster;

                if (strike > 0) {
                  if (!strikesStack.isEmpty()) {
                      strike += strikesStack.pop();
                  }
                  strikesStack.push(strike);
                }
            } else {
                    monster -= strike;
                    monstersQueue.offer(monster);
                }
            }
            if (monstersQueue.isEmpty()) {
                System.out.println("All monster have been killed");
            }
            if (strikesStack.isEmpty()) {
                System.out.println("The soldier has been defeated");
            }
            System.out.printf("Total monster killed: %d", killedMonster);
        }
    }

