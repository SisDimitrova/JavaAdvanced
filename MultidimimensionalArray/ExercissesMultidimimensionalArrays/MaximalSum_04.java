package ExercissesMultidimimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;


public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int bestStartingRow = 0;
        int bestStartingCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int startEl = matrix[row][col];
                int sum = startEl + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 2][col]
                        + matrix[row + 1][col + 1] + matrix[row + 2][col + 2]
                        + matrix[row + 2][col + 1] + matrix[row + 1][col + 2];


                  if (sum > maxSum) {
                      maxSum = sum;
                      bestStartingRow = row;
                      bestStartingCol = col;

                  }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = bestStartingRow; row <= bestStartingRow + 2 ; row++) {
            for (int col = bestStartingCol; col <= bestStartingCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }


    }
}


