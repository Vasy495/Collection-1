package driver;

import transport.Truck;

public class DriverD extends Driver<Truck>{
    public DriverD(String fullName, int drivingExperience, Truck car) {
        super(fullName, "D", drivingExperience, car);
    }
}
