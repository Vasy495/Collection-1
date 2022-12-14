import ExceptionPassword.Data;
import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import transport.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Mechanic<Car> petr = new Mechanic<Car>("Петр", "Петров", "Pirelli");
        Mechanic<Bus> ivan = new Mechanic<Bus>("Иван", "Иванов", "LAC");
        Mechanic<Truck> semen = new Mechanic<Truck>("Семен", "Семенов", "Spar");
        Sponsor lukoil = new Sponsor("Лукоил", 2_000_000);
        Sponsor gazprom = new Sponsor("Газпром", 3_000_000);

        Car ladaGranta = new Car("Лада", "Гранта", 1.4f, BodyType.SEDAN);
        ladaGranta.addDriver(new DriverB("Водитель 1", 25, ladaGranta));
        ladaGranta.addMechanic(petr);
        ladaGranta.addSponsor(lukoil, gazprom);

        Car ladaVesta = new Car("Лада", "Веста", 1.8f, BodyType.COUPE);
        Car uazPatriot = new Car("УАЗ", "Патриот", 2.4f, BodyType.PICKUP);
        Car ladaPriora = new Car("Лада", "Приора", 1.6f, BodyType.HATCHBACK);

//        System.out.println(ladaGranta);
//        System.out.println("Лучшее время круга: " + ladaGranta.getBestLapTime());
//        ladaGranta.startMovement();
//        ladaGranta.stopMovement();

        Truck kamaz1 = new Truck("Камаз1", "12 тонн", 8.0f, CargoType.N1);
        kamaz1.addDriver(new DriverD("Максим", 3, kamaz1));
        kamaz1.addMechanic(semen);
        kamaz1.addSponsor(gazprom);
        Truck kamaz2 = new Truck("Камаз2", "12 тонн", 8.0f, CargoType.N2);
        Truck kamaz3 = new Truck("Камаз3", "12 тонн", 8.0f, CargoType.N3);
        Truck kamaz4 = new Truck("Камаз4", "12 тонн", 8.0f, CargoType.N2);

//        System.out.println(kamaz1);
//        System.out.println("Лучшее время круга: " + kamaz1.getBestLapTime());

        Bus bus1 = new Bus("Белаз", "2125", 6.0f, CapacityType.LARGE);
        bus1.addDriver(new DriverC("Максим", 3, bus1));
        bus1.addMechanic(ivan);
        bus1.addSponsor(lukoil);
        Bus bus2 = new Bus("Белаз2", "2125", 6.0f, null);
        Bus bus3 = new Bus("Белаз3", "2125", 6.0f, CapacityType.SMALL);
        Bus bus4 = new Bus("Белаз4", "2125", 6.0f, CapacityType.EXTRA_LARGE);

//        System.out.println(bus1);
//        System.out.println("Лучшее время круга: " + bus1.getBestLapTime());

//        DriverB driverB = new DriverB("А", 25, ladaGranta);
//        DriverC driverC = new DriverC("C", 5, bus1);
//        DriverD driverD = new DriverD("C", 15, kamaz1);
//        System.out.println(driverB);
//        driverB.refill();

//        kamaz1.defineType();
//        bus2.defineType();
//        bus3.defineType();

        System.out.println();

        List<Transport> transports = List.of(ladaGranta, kamaz1, bus1);

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(ladaGranta);
        serviceStation.addCar(ladaVesta);
        serviceStation.addTruck(kamaz1);
        serviceStation.addTruck(kamaz2);
        System.out.println("Очередь на ремонт: " + serviceStation.getTransports().size());
        serviceStation.service();
        serviceStation.service();
        System.out.println("Очередь на ремонт: " + serviceStation.getTransports().size());
        System.out.println();

        for (Transport transport : transports) {
            printInfo(transport);
            System.out.println();
        }
//ДЗ с очередью:
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        randomFilling(queue1);
        randomFilling(queue2);
        System.out.println("Первая очередь " + queue1);
        System.out.println("Вторая очередь " + queue2);
        System.out.println();

        add("Владимир Петров",queue1,queue2);
        System.out.println("Первая очередь " + queue1);
        System.out.println("Вторая очередь " + queue2);
        System.out.println();

        remove(queue1,queue2);
        System.out.println("Первая очередь " + queue1);
        System.out.println("Вторая очередь " + queue2);

        //HW 3
        example();
    }

    private static final List<String> NAMES = List.of(
            "Иван Иванов", "Петр Петров",
            "Николай Николаев", "Мария Алексеевна",
            "Иван Иванов3", "Петр Петров3",
            "Иван Иванов2", "Петр Петров2",
            "Иван Иванов4", "Петр Петров4"
    );
    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 5;
    private static void randomFilling(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }
    private static void add(String name,
                            Queue<String> queue1,
                            Queue<String> queue2) {
        if (queue1.size() <= queue2.size() && queue1.size() != MAX_SIZE) {
            queue1.offer(name);
        } else if (queue2.size() < queue1.size() && queue2.size() != MAX_SIZE) {
            queue2.offer(name);
        } else {
            System.out.println("Нужно позвать Галю");
        }
    }
    private static void remove(Queue<String> queue1,
                               Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }
//Окончание ДЗ с очередью


    private static void example(){
        List<List<String>> biDemArrList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                biDemArrList.get(i).add(j, (i + j) % 2 == 1 ? "1" : "0");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                    System.out.print(biDemArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    private static void printInfo(Transport transport) {
        System.out.println("Информация по транспортному средству: " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Водители: " + transport.getDrivers());
        System.out.println("Механники: " + transport.getMechanics());
        System.out.println("Спонсоры: " + transport.getSponsors());
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