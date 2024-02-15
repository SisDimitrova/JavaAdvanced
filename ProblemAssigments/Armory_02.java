package ProblemAssignments;

import java.util.Scanner;

public class Armory_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        int [] officerCoordinates = findCoordinates(matrix, "A");

        int officerRow = officerCoordinates[0];
        int officerCol = officerCoordinates[1];

        matrix[officerRow][officerCol] = "-";

         int goldCoins = 0;

        while (goldCoins < 65) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }
            if (isOutOfMatrix(matrix, officerRow, officerCol)) {
                break;
            }
            String officerPosition = matrix[officerRow][officerCol];
            matrix[officerRow][officerCol] = "-";   // tam kudeto stupim stava ravno na -
            if ("M".equals(officerPosition)) {// trqbva da se teleportirame
                int[] mirrorCoordinates = findCoordinates(matrix, "M");

                int mirrorRow = mirrorCoordinates[0];
                int mirrorCol = mirrorCoordinates[1];
                officerRow = mirrorRow;
                officerCol = mirrorCol;
                matrix[officerRow][officerCol] = "-";

            } else if (!"-".equals(officerPosition)){   // stupil e na cifra
                 goldCoins+= Integer.parseInt(officerPosition);
            }
        }
          if (goldCoins >= 65) {
              matrix[officerRow][officerCol] = "A";
              System.out.println("Very nice swords, I will come back for more!");
          } else {
              System.out.println("I do not need more swords!");
          }
        System.out.printf("The king paid %d gold coins.%n", goldCoins);

        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = currentRow[col];

            }
        }
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

    private static boolean isOutOfMatrix(String[][] matrix, int officerRow, int officerCol) {
        return officerRow < 0 || officerRow >= matrix.length ||
                officerCol < 0 || officerCol >= matrix[officerRow].length;
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
