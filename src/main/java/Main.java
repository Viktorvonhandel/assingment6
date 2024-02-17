 
import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    protected String manufacturer;
    protected String model;
    protected int maxSpeed;
    protected Engine engine;

    public Vehicle(String manufacturer, String model, int maxSpeed) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getInfo() {
        return manufacturer + " " + model + "\nMoottori: " + engine.getName() + " " + engine.getPower() + "kW\nHuippunopeus: " + maxSpeed + "km/h";
    }
}

class Car extends Vehicle {
    public Car(String manufacturer, String model, int maxSpeed) {
        super(manufacturer, model, maxSpeed);
        setEngine(new Engine("V8", 300));
    }

    public void drive() {
        System.out.println(manufacturer + " " + model + " paahtaa tietä eteenpäin!");
    }
}

class Plane extends Vehicle {
    public Plane(String manufacturer, String model, int maxSpeed) {
        super(manufacturer, model, maxSpeed);
        setEngine(new Engine("Suihkumoottori", 500));
    }

    public void fly() {
        System.out.println(manufacturer + " " + model + " lentää kohteeseen!");
    }
}

class Ship extends Vehicle {
    public Ship(String manufacturer, String model, int maxSpeed) {
        super(manufacturer, model, maxSpeed);
        setEngine(new Engine("Wärtsilä Super", 1000));
    }

    public void sail() {
        System.out.println(manufacturer + " " + model + " seilaa merten ääriin!");
    }
}

class Engine {
    private String name;
    private int power;

    public Engine(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        int choice;
        do {
            System.out.println("1) Luo uusi kulkuneuvo, 2) Listaa kulkuneuvot 3) Aja autoja, 4) Lennä lentokoneita, 5) Seilaa laivoja, 0) Lopeta ohjelma");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Minkä kulkuneuvon haluat rakentaa? 1) auto, 2) lentokone, 3) laiva");
                    int typeChoice = scanner.nextInt();
                    System.out.println("Anna kulkuneuvon valmistaja:");
                    String manufacturer = scanner.next();
                    System.out.println("Anna kulkuneuvon malli:");
                    String model = scanner.next();
                    System.out.println("Anna kulkuneuvon huippunopeus:");
                    int maxSpeed = scanner.nextInt();
                    switch (typeChoice) {
                        case 1:
                            vehicles.add(new Car(manufacturer, model, maxSpeed));
                            break;
                        case 2:
                            vehicles.add(new Plane(manufacturer, model, maxSpeed));
                            break;
                        case 3:
                            vehicles.add(new Ship(manufacturer, model, maxSpeed));
                            break;
                        default:
                            System.out.println("Virheellinen valinta.");
                    }
                    break;
                case 2:
                    for (Vehicle vehicle : vehicles) {
                        System.out.println(vehicle.getInfo());
                    }
                    break;
                case 3:
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle instanceof Car) {
                            ((Car) vehicle).drive();
                        }
                    }
                    break;
                case 4:
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle instanceof Plane) {
                            ((Plane) vehicle).fly();
                        }
                    }
                    break;
                case 5:
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle instanceof Ship) {
                            ((Ship) vehicle).sail();
                        }
                    }
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    break;
                default:
                    System.out.println("Virheellinen valinta.");
            }
        } while (choice != 0);
        scanner.close();
    }
}