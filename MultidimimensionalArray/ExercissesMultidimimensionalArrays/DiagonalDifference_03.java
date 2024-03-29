package ExercissesMultidimimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

            fillMatrix(matrix, scanner);

            int sumPrimaryDiagonal = getSumElementsOnPrimaryDiagonal(matrix);

            int sumSecondaryDiagonal = getSumElementsOnSecondaryDiagonal(matrix);

        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));

    }

    private static int getSumElementsOnSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentEl = matrix[row][col];
                if (col == matrix.length - row - 1) {
                    sum += currentEl;
                }
            }
        }
        return sum;
    }

    private static int getSumElementsOnPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentEl = matrix[row][col];
                if (row == col) {
                    sum += currentEl;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        int rows = matrix.length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
