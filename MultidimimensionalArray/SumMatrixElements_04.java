package MultidimimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizeArray = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = sizeArray[0];
        int cols = sizeArray[1];
        System.out.println(rows);
        System.out.println(cols);

        int[][] sumArray = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            sumArray[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        for (int row = 0; row < sumArray.length; row++) {
            for (int col = 0; col < sumArray[row].length; col++) {
                sum += sumArray[row][col];
            }
        }
        System.out.println(sum);
    }
}
