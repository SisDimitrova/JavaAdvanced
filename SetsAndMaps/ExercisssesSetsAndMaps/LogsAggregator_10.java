package ExercissesSetsAndMaps;

import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> userTames = new TreeMap<>();
        Map<String, TreeSet<String>>  ipAddresses = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String ip = line[0];
            String name = line[1];
            int time = Integer.parseInt(line[2]);

            userTames.putIfAbsent(name, 0);
            ipAddresses.putIfAbsent(name, new TreeSet<>(){{add(ip);}});
            if (userTames.containsKey(name)) {
                userTames.put(name, userTames.get(name) + time);
                ipAddresses.get(name).add(ip);
            }
        }
        userTames.forEach((key, value) ->{

            System.out.println(String.format("%s: %d %s", key, value, ipAddresses.get(key).toString()));

        });
    }
}
