package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Car.java
public class Car {
    private String id;
    private String model;
    private boolean available;
    private double pricePerDay;

    public Car(String id, String model, double pricePerDay) {
        this.id = id;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public double getPricePerDay() { return pricePerDay; }
}


