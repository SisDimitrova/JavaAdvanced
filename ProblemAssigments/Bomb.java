package ProblemAssignments;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[matrixSize][matrixSize];
        int sapperRow = 0;
        int sapperCol = 0;
        int counterBomb = 0;

        for (int i = 0; i < matrixSize; i++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(e -> e.charAt(0))
                    .collect(Collectors.toList());
            for (int j = 0; j < characterList.size(); j++) {
                char currentChar = characterList.get(j);
                if (currentChar == 's') {
                    sapperRow = i;
                    sapperCol = j;
                } else if (currentChar == 'B') {
                    counterBomb++;
                }
                matrix[i][j] = currentChar;

            }
        }
        int bombFound = 0;
        for (int i = 0; i < commands.length; i++) {
            String commandName = commands[i];
            switch (commandName) {
                case "up":
                    if (sapperRow != 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow != matrixSize - 1) {
                        sapperRow++;
                    }
                    break;
                case "left":
                    if (sapperCol != 0 ) {
                        sapperCol--;
                    }
                    break;
                case "right":
                    if (sapperCol != matrixSize - 1) {
                        sapperCol++;
                    }
                    break;
            }
            if (matrix[sapperRow][sapperCol] == 'B') {
                System.out.println("Yоu found a bomb");
                matrix[sapperRow][sapperCol] = '+';
                bombFound++;
                if (bombFound == counterBomb) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", counterBomb - bombFound);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", counterBomb - bombFound, sapperRow, sapperCol);

    }
}
