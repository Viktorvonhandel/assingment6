package gasthief;

public class Ship extends Vehicle {
    public Ship(String manufacturer, String model, int maxSpeed) {
        super(manufacturer, model, maxSpeed);
        setEngine(new Engine("Wärtsilä Super", 1000));
    }

    public void sail() {
        System.out.println(manufacturer + " " + model + " seilaa merten ääriin!");
    }
}
