package RawData_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Car>> carsCargoType = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String model = line[0];
            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tireList = new ArrayList<>();

            for (int tireItems = 5; tireItems <= 12 ; tireItems += 2) {
                Tire currentTire = new Tire(Double.parseDouble(line[tireItems]), Integer.parseInt(line[tireItems + 1]));
                tireList.add(currentTire);
            }
            Car currentCar = new Car(model, engine, cargo, tireList);
            carsCargoType.putIfAbsent(cargoType, new ArrayList<>());
            carsCargoType.get(cargoType).add(currentCar);


        }
        String command = scanner.nextLine();
        carsCargoType.get(command).forEach(car -> car.extract(command));
    }
}
