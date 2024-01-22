package ExercissesSetsAndMaps;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class PopulationCounter_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        Map<String, Long> totalPopulation = new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();
            if ("report".equals(line)) {
                break;
            }
            String[] countryData = line.split("\\|");
            String city = countryData[0];
            String country = countryData[1];
            long population = Long.parseLong(countryData[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            totalPopulation.putIfAbsent(country, 0L);

            Long currentPopulation = totalPopulation.get(country);
            totalPopulation.put(country, currentPopulation + population);

            countries.get(country).put(city, population);
        }
        totalPopulation.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n",entry.getKey(), entry.getValue());
                    countries.get(entry.getKey())
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach((pair) -> {
                                System.out.printf("=>%s: %d%n", pair.getKey(), pair.getValue());
                    });

                });
    }
}
