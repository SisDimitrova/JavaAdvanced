package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> regular = new TreeSet<>();
        Set<String> VIP = new TreeSet<>();
        String guests = scanner.nextLine();
        while (!"PARTY".equals(guests)) {

            if (Character.isDigit(guests.charAt(0))) {
                VIP.add(guests);
            } else {
                regular.add(guests);
            }
            guests = scanner.nextLine();
        }

            while (!"END".equals(guests)) {

               VIP.remove(guests);
               regular.remove(guests);
               guests = scanner.nextLine();
            }
            System.out.println(VIP.size() + regular.size());
            for (String vipGuest : VIP) {
                System.out.println(vipGuest);
            }
            for (String regularGuests: regular) {
                System.out.println(regularGuests);
            }
        }

    }

