package ExercissesMultidimimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        while (true) {
            String command = scanner.nextLine();
            if ("END".equals(command)) {
                break;
            }

                String[] commandsParts = command.split("\\s+");
            if (validCommand(commandsParts, rows, cols)) {
                int rowFirstEl = Integer.parseInt(commandsParts[1]);
                int colFirstEl = Integer.parseInt(commandsParts[2]);
                int rowSecondEl = Integer.parseInt(commandsParts[3]);
                int colSecondEl = Integer.parseInt(commandsParts[4]);

                String firstElement = matrix[rowFirstEl][colFirstEl];
                String secondElement = matrix[rowSecondEl][colSecondEl];
                matrix[rowFirstEl][colFirstEl] = secondElement;
                matrix[rowSecondEl][colSecondEl] = firstElement;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static boolean validCommand(String[] commandsParts, int rows, int cols) {
        if (commandsParts.length != 5) {
            return false;
        }
        if (!"swap".equals(commandsParts[0])) {
            return false;
        }
        int rowFirstEl = Integer.parseInt(commandsParts[1]);
        int colFirstEl = Integer.parseInt(commandsParts[2]);

        int rowSecondEl = Integer.parseInt(commandsParts[3]);
        int colSecondEl = Integer.parseInt(commandsParts[4]);
        if (rowFirstEl >= 0 && rowFirstEl <= rows && rowSecondEl >= 0 && rowSecondEl <= rows
        && colFirstEl >= 0 && colFirstEl <= cols && colSecondEl >= 0 && colSecondEl <= cols) {
             return true;
        } else {
            return false;
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (String [] row : matrix) {
            for (String element: row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");

        }


    }
}
