package ProblemAssignments;

import java.util.*;

public class ItIsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque<>();
        Deque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble)
                .forEach(milkQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble)
                .forEach(cacaoStack::push);

        Map<String, Integer> chocolateList = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
           double milk = milkQueue.poll();
            double cacao =cacaoStack.pop();
            
            double chocolate = (cacao / (milk + cacao)) * 100;
            
            if (chocolate == 30) {
                chocolateList.putIfAbsent("Milk", 0);
                chocolateList.put("Milk", chocolateList.get("Milk") + 1);
            } else if (chocolate == 50) {
                chocolateList.putIfAbsent("Dark", 0);
                chocolateList.put("Dark", chocolateList.get("Dark") + 1);
            } else if (chocolate == 100) {
                chocolateList.putIfAbsent("Baking", 0);
                chocolateList.put("Baking", chocolateList.get("Baking") + 1);
            } else {
                milk += 10;
                milkQueue.offer(milk);
            }

        }
        if (chocolateList.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolateList.forEach((k, v)-> System.out.printf("# %s Chocolate --> %d%n", k, v));
    }
}
