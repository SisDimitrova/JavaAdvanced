package SetsAndMaps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>>
              countriesDataByContinent = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            String continent = line[0];
            String country = line[1];
            String city = line[2];

            countriesDataByContinent.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> citiesByCountry = countriesDataByContinent.get(continent);
            citiesByCountry.putIfAbsent(country, new ArrayList<>());
            List<String> cities = citiesByCountry.get(country);
            cities.add(city);
        }
        countriesDataByContinent.entrySet().stream().forEach(entry ->{
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().stream().forEach(e -> {
                String cities = String.join(", ", e.getValue());

                System.out.println("  " + e.getKey() + " -> " + cities);
            });
        });

    }
}
