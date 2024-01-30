package SpeedRacing_03;

import java.awt.geom.Arc2D;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCar = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < countCar; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCostFor1km = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            cars.put(model, car);
        }
        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String carModelToDrive = command.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);

            Car carToDrive = cars.get(carModelToDrive);
            if (!carToDrive.drive(kmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }
        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }
}
