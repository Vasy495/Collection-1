import ExceptionPassword.Data;
import driver.DriverB;
import transport.*;

public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("Лада", "Гранта", 1.4f, BodyType.SEDAN);
        Car ladaVesta = new Car("Лада", "Веста", 1.8f, BodyType.COUPE);
        Car uazPatriot = new Car("УАЗ", "Патриот", 2.4f, BodyType.PICKUP);
        Car ladaPriora = new Car("Лада", "Приора", 1.6f, BodyType.HATCHBACK);

        System.out.println(ladaGranta);
        System.out.println("Лучшее время круга: " + ladaGranta.getBestLapTime());
        ladaGranta.startMovement();
        ladaGranta.stopMovement();

        Truck kamaz1 = new Truck("Камаз1", "12 тонн", 8.0f, CargoType.N1);
        Truck kamaz2 = new Truck("Камаз2", "12 тонн", 8.0f, CargoType.N2);
        Truck kamaz3 = new Truck("Камаз3", "12 тонн", 8.0f, CargoType.N3);
        Truck kamaz4 = new Truck("Камаз4", "12 тонн", 8.0f, CargoType.N2);

        System.out.println(kamaz1);
        System.out.println("Лучшее время круга: " + kamaz1.getBestLapTime());

        Bus bus1 = new Bus("Белаз", "2125", 6.0f, CapacityType.LARGE);
        Bus bus2 = new Bus("Белаз2", "2125", 6.0f, null);
        Bus bus3 = new Bus("Белаз3", "2125", 6.0f, CapacityType.SMALL);
        Bus bus4 = new Bus("Белаз4", "2125", 6.0f, CapacityType.EXTRA_LARGE);

        System.out.println(bus1);
        System.out.println("Лучшее время круга: " + bus1.getBestLapTime());

        DriverB driverB = new DriverB("А", 25, ladaGranta);
        System.out.println(driverB);
        driverB.refill();

        kamaz1.defineType();
        bus2.defineType();
        bus3.defineType();

        System.out.println();

        //HW1.ExceptionPassword
        System.out.print("HW.ExceptionPassword: ");
        boolean success = Data.validate("sgev", "1234", "12345");
        if (success) {
            System.out.print("Данные корректны");
        }

        //HW2.ExceptionTransport
        service(ladaVesta, ladaPriora, ladaGranta,kamaz2,bus1);
    }

    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            serviceTransport(transport);
        }
    }

    private static void serviceTransport(Transport transport) {
        try {
            if (!transport.service()) {
                throw new RuntimeException("Транспортное средство " + transport.getBrand() + " " + transport.getModel() + " сервис не прошел");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}