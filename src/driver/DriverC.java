package driver;

import transport.Bus;

public class DriverC extends Driver<Bus>{
    public DriverC(String fullName, int drivingExperience, Bus car) {
        super(fullName, "C", drivingExperience, car);
    }
}
