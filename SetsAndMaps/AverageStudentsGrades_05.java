package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
          String[] tokens = scanner.nextLine().split("\\s+");

          String name = tokens[0];
          Double grade = Double.parseDouble(tokens[1]);
          students.putIfAbsent(name, new ArrayList<>());
          students.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
              String k = entry.getKey();
              List<Double> v = entry.getValue();
              String result = v.stream().map(g -> String.format("%.2f", g)).collect(Collectors.joining(" "));
             double average =  v.stream().mapToDouble(e -> e).average().orElse(0);
            System.out.printf("%s -> %s (avg: %.2f)%n", k, result, average);
        }
    }
}
