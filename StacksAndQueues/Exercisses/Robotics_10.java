package ExercissesStacksAndQueues;

import java.util.*;

public class Robotics_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");

        String time = scanner.nextLine();
        String[] splitTime = time.split(":");

        int hours = Integer.parseInt(splitTime[0]);
        int minutes = Integer.parseInt(splitTime[1]);
        int seconds = Integer.parseInt(splitTime[2]);

        long totalSeconds = hours * 3600 + minutes * 60 + seconds;

        Map<String, Integer> robots = splitDataIntoLinkedHashMap(inputRobots);
        int[] processTimes = new int[robots.size()];

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();

        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }


        while (!products.isEmpty()) {
            totalSeconds++;
            String currentProduct = products.poll();
            boolean isAssigned = false;
            decreaseProcessTime(processTimes);
            for (int i = 0; i < processTimes.length; i++) {
                if (processTimes[i] == 0) {
                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if (count == i) {
                            processTimes[i] = robot.getValue();
                            isAssigned = true;
                            printJob(robot.getKey(), currentProduct, totalSeconds);
                            break;
                        }
                        count++;
                    }

                    break;
                }

            }
            if (!isAssigned) {
                products.offer(currentProduct);
            }

        }

    }


    private static void decreaseProcessTime(int[] processTimes) {
        for (int i = 0; i < processTimes.length; i++) {
            if(processTimes[i] > 0){
                --processTimes[i];
            }

        }
    }

    private static void printJob(String name, String product, long totalSeconds) {
        long hours = (totalSeconds / 3600) % 24;
        long minutes = totalSeconds % 3600 / 60;
        long seconds = totalSeconds % 60;
        if (hours >= 24) {
            hours -= 24;
        }
        System.out.printf("%s - %s [%02d:%02d:%02d]%n", name, product, hours, minutes, seconds);
    }

    private static Map<String, Integer> getStartProcessTimes(String[] inputRobots) {
        Map<String, Integer> processTimes = new LinkedHashMap<>();
        for (String input : inputRobots) {
            String name = input.split("-")[0];
            processTimes.put(name, 0);
        }
        return processTimes;
    }

    private static Map<String, Integer> splitDataIntoLinkedHashMap(String[] inputRobots) {
        Map<String, Integer> robots = new LinkedHashMap<>();
        for (String input : inputRobots) {
            String name = input.split("-")[0];
            int time = Integer.parseInt(input.split("-")[1]);
            if (!robots.containsKey(name)) {
                robots.put(name, time);
            }
        }
        return robots;
    }
}
