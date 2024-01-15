package MultidimimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readInputAsArray(scanner);

        int firstRows = dimensions[0];
        int firstCols = dimensions[1];

        int[][] firstArray = new int[firstRows][firstCols];

        for (int row = 0; row < firstRows; row++) {
            firstArray[row] = readInputAsArray(scanner);
        }
        int[] dimensionsSecond = readInputAsArray(scanner);

        int secondRows = dimensionsSecond[0];
        int secondCols = dimensionsSecond[1];

        int[][] secondArray = new int[secondRows][secondCols];

        for (int row = 0; row < secondRows; row++) {
            secondArray[row] = readInputAsArray(scanner);
        }
        if (!areEquals(dimensions, dimensionsSecond)) {
            System.out.println("not equal");
            return;
        }
        for (int i = 0; i < firstRows; i++) {
            if (!areEquals(firstArray[i], secondArray[i])) {
                System.out.println("not equal");
                return;
            }
        }
        System.out.println("equal");
    }
    public static boolean areEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        boolean areEquals = true;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                areEquals = false;
                break;
            }
        }
        return areEquals;
    }

    public static int[] readInputAsArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
