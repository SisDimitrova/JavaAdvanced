package SpeedRacing_03;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForOneKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostForOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKm = fuelCostForOneKm;
        this.distanceTraveled = 0;
    }
    public boolean drive(int kmDrive) {
        // нужно количество гориво, за да изминем дадените км
        double needFuel = kmDrive * this.fuelCostForOneKm;
        if (needFuel <= this.fuelAmount) {   // mojem da izminem razstoqnieto
            this.fuelAmount -= needFuel;
            this.distanceTraveled += kmDrive;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
