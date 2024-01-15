package MultidimimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 8;
        int cols = 8;

        char[][] chessTable = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            chessTable[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        for (int row = 0; row < chessTable.length; row++) {
            for (int element = 0; element < chessTable[row].length; element++) {
                char currentElement = chessTable[row][element];

                if (currentElement == 'q') {
                    if (check(chessTable, row, element)) {
                        System.out.print(row + " ");
                        System.out.print(element);
                    }
                }
            }
        }
    }

    private static boolean check(char[][] chessTable, int row, int element) {

        for (int i = element + 1; i < chessTable[row].length ; i++) { // десен хоризонтал
            char charToCheck = chessTable[row][i];
            if (charToCheck == 'q') {
                return false;
            }
        }
        for (int i = element - 1; i >= 0 ; i--) {                   // ляв хоризонтал
            char charToCheck = chessTable[row][i];
            if (charToCheck == 'q') {
                return false;
            }
        }
        for (int i = row + 1; i < chessTable.length; i++) {        // долен вертикал
            char charToCheck = chessTable[i][element];

            if (charToCheck == 'q') {
                return false;
            }
        }
        for (int i = row - 1; i >= 0; i--) {                     //  горен вертикал
            char charToCheck = chessTable[i][element];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int upLeftDiagonal = element - 1;
        for (int i = row - 1;upLeftDiagonal >= 0 ;i--, upLeftDiagonal--) {     //  ляв горен диагонал
            char charToCheck = chessTable[i][upLeftDiagonal];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int upRightDiagonal = element + 1;
                                                                               // горен десен диагонал
        for (int i = row - 1; i >= 0 && upRightDiagonal < chessTable[i].length ; i--, upRightDiagonal++) {
            char charToCheck = chessTable[i][upRightDiagonal];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int downLeftDiagonal = element - 1;
                                                                             // долен ляв диагонал
        for (int i = row + 1; i < chessTable.length && downLeftDiagonal >= 0; i++, downLeftDiagonal--) {
            char charToCheck = chessTable[i][downLeftDiagonal];

            if (charToCheck == 'q') {
                return false;
            }
        }
        int downRightDiagonal = element + 1;
                                                                           // долен десен диагонал
        for (int i = row + 1; i < chessTable.length && downRightDiagonal < chessTable[row].length;i++, downRightDiagonal++) {
            char charToCheck = chessTable[i][downRightDiagonal];

            if (charToCheck == 'q') {
                return false;
            }
        }
        return true;
    }
}
