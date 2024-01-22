package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> data = new TreeMap<>();

        while (true) {
            String line = scanner.nextLine();
            if ("Revision".equals(line)) {
                break;
            }
            String[] tokens = line.split(",\\s+");
            String nameShop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            data.putIfAbsent(nameShop, new LinkedHashMap<>());
            LinkedHashMap<String, Double> innerData = data.get(nameShop);

            innerData.putIfAbsent(product, price);
        }
        for (var entry : data.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (var productData : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productData.getKey(), productData.getValue());
            }
        }
    }
}
