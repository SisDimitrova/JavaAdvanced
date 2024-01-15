package MultidimimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int wrongValue = matrix[arr[0]][arr[1]];   //стойността на сгрешеното число намираща се в нашата матрица

        List<int[]> correctedValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                     int sum = 0;

                    if (isInBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongValue) {
                         // горе
                        sum += matrix[row - 1][col];
                    }
                    if (isInBounds(matrix, row , col - 1) && matrix[row][col - 1] != wrongValue) {
                        //ляво
                        sum += matrix[row][col - 1];
                    }
                    if (isInBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue) {
                        // долу
                        sum += matrix[row + 1][col];
                    }
                    if (isInBounds(matrix, row , col + 1) && matrix[row][col + 1] != wrongValue) {
                        // дясно
                        sum += matrix[row][col + 1];
                    }
                    int[] parameters = new int[3];
                    parameters[0] = row;
                    parameters[1] = col;
                    parameters[2] = sum;

                    correctedValues.add(parameters);
                }
            }
        }
        for (int[] correctedValue: correctedValues) {
              matrix[correctedValue[0]][correctedValue[1]] = correctedValue[2];
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {

        for (int[] arr: matrix) {
            for (int el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

}
