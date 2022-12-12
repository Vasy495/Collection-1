package driver;

import transport.Car;

public class DriverB extends Driver<Car>{
    public DriverB(String fullName, int drivingExperience, Car car) {
        super(fullName, "B", drivingExperience, car);
    }
}
