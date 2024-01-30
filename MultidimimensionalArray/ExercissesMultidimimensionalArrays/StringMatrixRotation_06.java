package ExercissesMultidimimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int rotationAngle = Integer.parseInt(rotation.split("[()]+")[1]) % 360;

        List<String> linesForMatrix = new ArrayList<>();
        int maxLength = 0;

        while (true) {
            String line = scanner.nextLine();
            if ("END".equals(line)) {
                break;
            }

            linesForMatrix.add(line);
            if (maxLength < line.length()) {
                maxLength = line.length();
            }
        }
        int rows = linesForMatrix.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < linesForMatrix.get(row).length()) {
                    matrix[row][col] = linesForMatrix.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        if (rotationAngle == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}


