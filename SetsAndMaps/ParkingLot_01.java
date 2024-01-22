package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        while (true) {
            String line = scanner.nextLine();
            if ("END".equals(line)) {
                break;
            }
            String[] token = line.split(",\\s+");
            if ("IN".equals(token[0])) {
                parking.add(token[1]);
            } else if ("OUT".equals(token[0])) {
                parking.remove(token[1]);
            }
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        for (String carNum : parking) {
            System.out.println(carNum);
        }
    }
}
