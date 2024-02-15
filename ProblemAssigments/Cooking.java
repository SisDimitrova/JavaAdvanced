package ProblemAssignments;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(ingredientsStack::push);

        Map<String, Integer> cookedFoods = new TreeMap<>();
        cookedFoods.put("Bread", 0);
        cookedFoods.put("Cake", 0);
        cookedFoods.put("Pastry", 0);
        cookedFoods.put("Fruit Pie", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int currentLiquid = liquidsQueue.pop();
            int currentIngredient = ingredientsStack.pop();

            int sum = currentLiquid + currentIngredient;
            String cookFood;
            switch (sum) {
                case 25:
                    cookFood = "Bread";
                break;
                case 50:
                    cookFood = "Cake";
                    break;
                case 75:
                    cookFood = "Pastry";
                    break;
                case 100:
                    cookFood = "Fruit Pie";
                    break;
                default:
                    cookFood = null;
            }
            if (cookFood != null) {
              int newValue = cookedFoods.get(cookFood) + 1;
              cookedFoods.put(cookFood, newValue);
            } else {
              ingredientsStack.push(currentIngredient + 3);
            }
        }
        boolean allFoodsAreCooked = cookedFoods.entrySet().stream().allMatch(e-> e.getValue() > 0);

        if (allFoodsAreCooked) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        String remainingLiquids = liquidsQueue.isEmpty() ? "none" : liquidsQueue.stream()
                        .map(String::valueOf)
                                .collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingLiquids);

        String remainingIngredients = ingredientsStack.isEmpty() ? "none" : ingredientsStack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingIngredients);

        cookedFoods.entrySet().forEach(e-> {
            System.out.println(e.getKey() + ": " + e.getValue());
        });
    }
}
