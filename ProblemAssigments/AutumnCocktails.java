package ProblemAssignments;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        Deque<Integer> freshnessStack = new ArrayDeque<>();

        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(ingredientsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(freshnessStack::push);


        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {

            int firstIngredients = ingredientsQueue.poll();

            if (firstIngredients == 0) {
                continue;
            }
            int lastFreshness = freshnessStack.pop();

            int totalLevel = firstIngredients * lastFreshness;

            switch (totalLevel) {
                case 150:
                    cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                    break;
                case 250:
                    cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                    break;
                case 300:
                    cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                    break;
                case 400:
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    break;
                default:
                    firstIngredients += 5;
                    ingredientsQueue.offer(firstIngredients);
                    break;
            }
        }
        if (cocktails.get("Pear Sour") > 0 && cocktails.get("The Harvest") > 0
                && cocktails.get("Apple Hinny") > 0 && cocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientsQueue.isEmpty()) {
            int sum = ingredientsQueue.stream().mapToInt(e -> e).sum();

        System.out.printf("Ingredients left: %d%n", sum);
    }
        if (cocktails.get("Apple Hinny") > 0) {
            System.out.printf("# Apple Hinny --> %d%n", cocktails.get("Apple Hinny"));
        }
        if (cocktails.get("High Fashion") > 0) {
            System.out.printf("# High Fashion --> %d%n", cocktails.get("High Fashion"));
        }
        if (cocktails.get("Pear Sour") > 0) {
            System.out.printf("# Pear Sour --> %d%n", cocktails.get("Pear Sour"));
        }
        if (cocktails.get("The Harvest") > 0) {
            System.out.printf("# The Harvest --> %d%n", cocktails.get("The Harvest"));
        }
        }
    }
