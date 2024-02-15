package ProblemAssignments;

import java.util.Scanner;

public class MouseAndCheese {
    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private  static boolean isInMatrix = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("M")) {
                row = i;
                col = line.indexOf("M");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.equals("up")) {
                moveMouse(matrix,  - 1, 0);
            } else if (command.equals("down")) {                 // kogato v zda4ata moje da ima dopulnitelen
                                                                          // edin i si6t hod
                moveMouse(matrix,  1, 0);
            } else if (command.equals("left")) {
                moveMouse(matrix, 0, - 1);
            } else if (command.equals("right")) {
                moveMouse(matrix, 0,   1);
            }
            if (!isInMatrix) {
                break;
            }

            command = scanner.nextLine();
        }
        if (!isInMatrix) {
            System.out.println("Where is the mouse?");
        }
        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }


        printMatrix(matrix);

    }

    private static void moveMouse(char[][] matrix, int rowMutator, int colMutator) {
         int nextRow = row + rowMutator;
         int nextCol = col + colMutator;
        boolean isBonusHit = false;

          if (!isInBounds(matrix, nextRow, nextCol)) {
              matrix[row][col] = '-';
              isInMatrix = false;
              return;
          }
        if (matrix[nextRow][nextCol] == 'c') {
            eatenCheese++;
        } else if (matrix[nextRow][nextCol] == 'B') {
             isBonusHit = true;
        }
        matrix[row][col] = '-';
        matrix[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;

        if (isBonusHit) {
            moveMouse(matrix, rowMutator, colMutator);
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


    private static void printMatrix(char[][] matrix){
            for (char[] arr : matrix) {
                for (char c : arr) {
                    System.out.print(c);
                }
                System.out.println();
            }

        }
    }




