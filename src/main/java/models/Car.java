package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private int year;
    private int doorCount;

    private int mileage;

    private String engine;
    private String body;
    private String transmission;
    private String fuelType;

    public Car() {
    }

//    public Car(int id, String model, int year, String brand,
//               String body, int doorCount, String fuelType, String transmission) {
//        this.id = id;
//        this.model = model;
//        this.year = year;
//        this.brand = brand;
//        this.body = body;
//        this.doorCount = doorCount;
//        this.fuelType = fuelType;
//        this.transmission = transmission;
//    }

    public Car(int id, String brand, String model,
               int year, int doorCount, int mileage,
               String engine, String body, String transmission,
               String fuelType) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.doorCount = doorCount;
        this.mileage = mileage;
        this.engine = engine;
        this.body = body;
        this.transmission = transmission;
        this.fuelType = fuelType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return id == car.id
                && doorCount == car.doorCount
                && Objects.equals(model, car.model)
                && Objects.equals(brand, car.brand)
                && Objects.equals(body, car.body)
                && Objects.equals(fuelType, car.fuelType)
                && Objects.equals(transmission, car.transmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, body, doorCount, fuelType, transmission);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id
                + ", brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", doorCount=" + doorCount
                + ", mileage=" + mileage
                + ", engine='" + engine + '\''
                + ", body='" + body + '\''
                + ", transmission='" + transmission + '\''
                + ", fuelType='" + fuelType + '\''
                + '}';
    }
}
