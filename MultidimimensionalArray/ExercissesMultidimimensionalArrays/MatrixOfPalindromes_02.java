package ExercissesMultidimimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols ; col++) {
                char outSide = (char)('a' + row);
                char middle = (char) ('a' + row + col);

                matrix[row][col] = "" + outSide + middle + outSide;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
