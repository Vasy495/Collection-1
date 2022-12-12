package driver;

import transport.Transport;

public abstract class Driver<T extends Transport>  {
    private String fullName;
    private String license;
    private int drivingExperience;
    private T car;


    public Driver(String fullName, String license, int drivingExperience, T car) {
        this.fullName = fullName;
        setLicense(license);
        this.drivingExperience = drivingExperience;
        this.car = car;
    }

    public void startMovement() {
        System.out.println("Водитель " + this.fullName + " начал движение");
        this.car.startMovement();
    }

    public void stopMovement() {
        System.out.println("Водитель " + this.fullName + " остановился");
        this.car.stopMovement();
    }

    public void refill() {
        System.out.println("Водитель " + this.fullName + " заправляет " + this.car.getBrand() + " " + this.car.getModel());
    }

    public String getFullName() {
        return fullName;
    }

    public String getLicense() {
        return license;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public T getCar() {
        return car;
    }

    public void setLicense(String license) {
        if (license == null) {
            throw new IllegalArgumentException("Необходимо указать правильную категорию прав!");
        }
        this.license = license;
    }

    @Override
    public String toString() {
        return "Водитель " + fullName + " управляет автомобилем " + car.getBrand() + " " + car.getModel() + " и будет участвовать в заезде";
    }
}
