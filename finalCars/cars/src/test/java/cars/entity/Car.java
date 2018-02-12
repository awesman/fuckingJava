package cars.entity;

public class Car {

    private String engine;
    private String transmission;
    private String year;
    private String name;
    private String model;

    public Car(String name, String model, String year) {
        this.name = name;
        this.model = model;
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public void setEngine(String engine) {
        if (engine.contains("-L")) {
            this.engine = engine.replace("-L", "-liter");
        } else {
            this.engine = engine;
        }
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
