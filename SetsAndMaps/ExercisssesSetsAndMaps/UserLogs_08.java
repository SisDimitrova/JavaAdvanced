package ExercissesSetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();

        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) {
                break;
            }
            //input = "IP={IP.Address} message={A&sample&message} user={username}"
            String ip = line.split("\\s+")[0].split("=")[1];
            String username = line.split("\\s+")[2].split("=")[1];

            data.putIfAbsent(username, new LinkedHashMap<>());
            Map<String, Integer> currentIp = data.get(username);
            if (!currentIp.containsKey(ip)) {
                currentIp.put(ip, 1);
            } else {
                currentIp.put(ip, currentIp.get(ip) + 1);
            }
        }
        for (String username : data.keySet()) {
            //data.keySet() -> списък с всички usernames
            System.out.println(username + ": ");

            //ip-тата на username
            Map<String, Integer> currentIps = data.get(username); //map с ip-ата на дадения username

            int countIps = currentIps.size(); //брой на ip-тата = брой на записите в мап
            //currentIps: ip (key) -> count(value)
            for (String ip : currentIps.keySet()) {
                if (countIps == 1) {
                    //Последното ip за отпечатване
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                } else {
                    //не ми е последното ip
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                }
                countIps--;
            }
        }
    }
}
