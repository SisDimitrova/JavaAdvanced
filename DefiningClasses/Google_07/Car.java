package Google_07;

public class Car {
    private String model;
    private int speedCar;

    public Car(String model, int speedCar) {
        this.model = model;
        this.speedCar = speedCar;
    }

    @Override
    public String toString() {
        return model + " " + speedCar;
    }
}
