package MultidimimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            secondMatrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        char[][] result = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char a = firstMatrix[row][col];
                char b = secondMatrix[row][col];

                result[row][col] = a == b ? a:'*';
            }
        }
        printMultiDimArray(result);
    }
    public static void printMultiDimArray(char[][] array) {
        for (int row = 0; row < array.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < array[row].length; col++) {
                sb.append(array[row][col])
                        .append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
