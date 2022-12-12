package transport;

public class Truck extends Transport implements Competing {

    private CargoType cargoType;

    public Truck(String brand, String model, float engineVolume, CargoType cargoType) {
        super(brand, model, engineVolume);
        this.cargoType = cargoType;
    }

    @Override
    public String toString() {
        return "Грузовик:" +
                " Бренд = " + getBrand() +
                " / Модель = " + getModel() +
                " / Объем двигателя = " + getEngineVolume();
    }

    @Override
    public void defineType() {
            if (cargoType == null) {
                System.out.println("Данных по авто недостаточно");
            } else {
                System.out.println("Тип авто - " + cargoType + ". Грузоподъемность от " + cargoType.getFrom() + " до " + cargoType.getTo());
            }
        }

    @Override
    public void startMovement() {
        System.out.println("Car " + getBrand() + " " + getModel() + " started moving");
    }

    @Override
    public void stopMovement() {
        System.out.println("Car " + getBrand() + " " + getModel() + " stopped moving");
    }

    @Override
    public boolean service() {
        return Math.random() > 0.75;
    }

    @Override
    public String getPitStop() {
        return "Пит стоп - 3 раза";
    }

    @Override
    public int getBestLapTime() {
        return 35;
    }

    @Override
    public int getMaxSpeed() {
        return 45;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }
}
