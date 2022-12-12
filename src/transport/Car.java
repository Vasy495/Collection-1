package transport;

public class Car extends Transport implements Competing {

    private BodyType bodyType;

    public Car(String brand, String model, float engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }


    @Override
    public void defineType() {
        if (bodyType == null) {
            System.out.println("Данных по авто недостаточно");
        } else {
            System.out.println("Тип авто - " + bodyType);
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
        return Math.random() > 0.5;
    }

    @Override
    public String getPitStop() {return "Пит стоп - 2 раза"; }

    @Override
    public int getBestLapTime() {
        return 25;
    }

    @Override
    public int getMaxSpeed() {
        return 120;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Грузовик:" +
                " Бренд = " + getBrand() +
                " / Модель = " + getModel() +
                " / Объем двигателя = " + getEngineVolume();
    }
}
