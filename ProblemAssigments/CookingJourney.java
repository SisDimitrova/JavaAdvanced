package ProblemAssignments;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] partyShop = new String[n][n];
        int currentRow = 0;
        int currentCol = 0;

        int firstPillarRow = 0;
        int firstPillarCol = 0;

        int secondPillarRow = 0;
        int secondPillarCol = 0;

        boolean weFoundFirstPillar = false;

        for (int row = 0; row < n; row++) {
            String[] line = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                partyShop[row][col] = line[col];

                if ("S".equals(partyShop[row][col])) {
                    currentRow = row;
                    currentCol = col;
                }
                if ("P".equals(partyShop[row][col]) && !weFoundFirstPillar) {
                    firstPillarRow = row;
                    firstPillarCol = col;
                    weFoundFirstPillar = true;
                }
                if ("P".equals(partyShop[row][col]) && weFoundFirstPillar) {
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
            }
        }
        int money = 0;

        while (money < 50) {
            String command = scanner.nextLine();

            int oldRow = currentRow;
            int oldCol = currentCol;
             if (command.equals("left")) {
                 currentCol--;
             } else if (command.equals("right")) {
                 currentCol++;
             } else if (command.equals("up")) {
                 currentRow--;
             } else if (command.equals("down")) {
                 currentRow++;
             }
            if (currentRow < 0 || currentCol < 0 || currentCol >= n || currentRow >= n) {
                partyShop[oldRow][oldCol] = "-";
                break;
            }
          if (currentCol == firstPillarCol && currentRow == firstPillarRow) {  //trqbva da idem na vtoriq pilon
              currentCol = secondPillarCol;
              currentRow = secondPillarRow;
              partyShop[oldRow][oldCol] = "-";
              partyShop[firstPillarRow][firstPillarCol] = "-";
              partyShop[currentRow][currentCol] = "S";
          } else if (currentRow == secondPillarRow && currentCol == secondPillarCol) {
              currentRow = firstPillarRow;
              currentCol = firstPillarCol;
              partyShop[oldRow][oldCol] = "-";
              partyShop[secondPillarRow][secondPillarCol] = "-";
              partyShop[currentRow][currentCol] = "S";
          } else if (partyShop[currentRow][currentCol].equals("-")) {
            partyShop[oldRow][oldCol] = "-";
            partyShop[currentRow][currentCol] = "S";

          } else {
              money += Integer.parseInt(partyShop[currentRow][currentCol]);
              partyShop[oldRow][oldCol] = "-";
              partyShop[currentRow][currentCol] = "S";
          }
        }
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.println("Money: " + money);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(partyShop[row][col]);
            }
            System.out.println();
        }
    }
}