package transport;

public class Bus extends Transport implements Competing{

    private CapacityType capacityType;

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
        System.out.println("Автобус " + getBrand() + " " + getModel() + " диагностика не требуется");
        return true;
    }

    public Bus(String brand, String model, float engineVolume, CapacityType capacityType) {
        super(brand, model, engineVolume);
        this.capacityType = capacityType;
    }

    @Override
    public void defineType() {
        if (capacityType == null) {
            System.out.println("Данных по авто недостаточно");
        } else {
            String from = capacityType.getFrom() == null ? " нет данных " : " от " + capacityType.getFrom();

            String to = capacityType.getTo() == null ? " нет данных " : " до " + capacityType.getTo();

            System.out.println("Тип авто - " + capacityType + ". Вместимость " + from + to);
        }
    }

    @Override
    public String toString() {
        return "Автобус:" +
                " Бренд = " + getBrand() +
                " / Модель = " + getModel() +
                " / Объем двигателя = " + getEngineVolume();
    }

    @Override
    public String getPitStop() {
        return "Пит стоп - 6 раз";
    }

    @Override
    public int getBestLapTime() {
        return 11;
    }

    @Override
    public int getMaxSpeed() {
        return 600;
    }

    public CapacityType getCapacityType() {
        return capacityType;
    }

    public void setCapacityType(CapacityType capacityType) {
        this.capacityType = capacityType;
    }
}
