package ProblemAssignments;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
               .mapToInt(Integer::parseInt).toArray();

       int rows = dimensions[0];
       int cols = dimensions[1];

       int startRow = -1;  // zapazvame startovata poziciq
       int startCol = -1;

       String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split("");

            for (int col = 0; col < currentRow.length; col++) {
                matrix[row][col] = currentRow[col];

                if ("B".equals(matrix[row][col])) {
                   startRow = row;
                   startCol = col;
                }
            }
        }
        int boyRow = startRow;
        int boyCol = startCol;
        boolean isLeft = false;
        while (!isLeft) {   // proverqvame dali sme stupili na A , P ili -
            if ("P".equals(matrix[boyRow][boyCol])) {
                System.out.println("Pizza is collected. 10 minutes for delivery.");
                matrix[boyRow][boyCol] = "R";
            } else if ("-".equals(matrix[boyRow][boyCol])) {
                matrix[boyRow][boyCol] = ".";
            } else if ("A".equals(matrix[boyRow][boyCol])) {
                matrix[boyRow][boyCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");  // picata e dostavena i prekusvame
                break;
            }


            String command = scanner.nextLine();
            switch (command) {
                case "up":                    // proverqvqme purvo dali indexa e v matricata
                    if (boyRow - 1 >= 0) {
                        if ("*".equals(matrix[boyRow - 1][boyCol])) {
                            continue;
                        }
                    }
                    boyRow--;  //i togava se mestim
                    break;
                case "down":
                    if (boyRow + 1 < matrix.length) {
                        if ("*".equals(matrix[boyRow + 1][boyCol])) {
                            continue;
                        }
                    }
                    boyRow++;
                    break;
                case "left":
                    if (boyCol - 1 >= 0) {
                        if ("*".equals(matrix[boyRow][boyCol - 1])) {
                            continue;
                        }
                    }
                    boyCol--;
                    break;
                case "right":
                    if (boyCol + 1 < matrix[boyRow].length) {
                        if ("*".equals(matrix[boyRow][boyCol + 1])) {
                            continue;
                        }
                    }
                    boyRow++;
                    break;
            }
           isLeft = isOutOfTheMatrix(matrix, boyRow, boyCol);
        }
          if (isLeft) {
              matrix[startRow][startCol] = " ";      // stupva izvun poleto
              System.out.println("The delivery is late. Order is canceled.");
          }

        printMatrix(matrix);
    }

    private static boolean isOutOfTheMatrix(String[][] matrix, int boyRow, int boyCol) { // proverka dali sme izvun
                                                                                              // matricata
        return boyRow < 0 || boyRow >= matrix.length ||
                boyCol < 0 || boyCol >= matrix[boyRow].length;
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
