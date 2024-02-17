package gasthief;
public class Vehicle {
    protected String manufacturer;
    protected String model;
    protected int maxSpeed;
    protected String type;
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
        return type +":" + manufacturer + " " + model + "\nMoottori: " + engine.getName() + " " + engine.getPower() + "kW\nHuippunopeus: " + maxSpeed + "km/h\n";
    }
}