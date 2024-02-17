package ProblemAssignments;

import java.util.Scanner;

public class TheGambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        int [] playerCoordinates = findCoordinates(matrix, "G");
        int playerRow = playerCoordinates[0];
        int playerCol = playerCoordinates[1];

        matrix[playerRow][playerCol] = "-";

        int amount = 100;

        while (true) {
            String command = scanner.nextLine();
            if ("end".equals(command)) {
                break;
            }
            matrix[playerRow][playerCol] = "-";
            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }
            if (isOutOfMatrix(matrix, playerRow, playerCol)) {
                System.out.println("Game over! You lost everything!");
                break;
            }
            String playerPosition = matrix[playerRow][playerCol];
             if ("W".equals(playerPosition)) {
                amount += 100;
            } else if ("P".equals(playerPosition)) {
                amount-= 200;
                if (amount < 0) {
                    break;
                }
            } else if ("J".equals(playerPosition)){
                amount+= 100_000;
                break;
            }
        }
        if (amount > 100_000) {
            matrix[playerRow][playerCol] = "G";
            System.out.println("You win the Jackpot!");
            System.out.printf("End of the game. Total amount: %d$%n", amount);
            printMatrix(matrix);
        } else if (amount > 0){
            matrix[playerRow][playerCol] = "G";
            System.out.printf("End of the game. Total amount: %d$%n", amount);
            printMatrix(matrix);
        }
        if (amount < 0) {
            System.out.println("Game over! You lost everything!");
        }

    }

    private static boolean isOutOfMatrix(String[][] matrix, int playerRow, int playerCol) {
        return playerRow < 0 || playerRow >= matrix.length ||
                playerCol < 0 || playerCol >= matrix[playerRow].length;
    }

    private static int[] findCoordinates(String[][] matrix, String symbol) {
        int[] coordinates = new int[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
                if (symbol.equals(matrix[row][col])) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }

        return coordinates;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];
            }
        }
    }
        private static void printMatrix(String[][] matrix) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

