package SetsAndMaps;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> studentsData = new TreeMap<>();

        for (int i = 0; i < countStudents; i++) {
            String name = scanner.nextLine();
            String[] gradesString = scanner.nextLine().split("\\s+");
            Double[] grades = new Double[gradesString.length];
            for (int j = 0; j < gradesString.length; j++) {
                grades[j] = Double.parseDouble(gradesString[j]);
            }
            studentsData.put(name, grades);
        }
        DecimalFormat df = new DecimalFormat("0.################");
        studentsData.entrySet().forEach(e -> {
            double grade = 0;
            for (int i = 0; i < e.getValue().length; i++) {
                grade+= e.getValue()[i];
            }
            double average = grade / e.getValue().length;
            System.out.printf("%s is graduated with %s%n", e.getKey(), df.format(average));
        });
    }
}
