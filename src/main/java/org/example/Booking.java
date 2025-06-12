package org.example;

// Booking.java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private String pickupLocation;
    private String returnLocation;
    private List<String> extras;
    private boolean isExtended;

    public Booking(String id, User user, Car car, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.extras = new ArrayList<>();
        this.isExtended = false;
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public Car getCar() { return car; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public String getReturnLocation() { return returnLocation; }
    public void setReturnLocation(String returnLocation) { this.returnLocation = returnLocation; }
    public List<String> getExtras() { return extras; }
    public boolean isExtended() { return isExtended; }

    public void addExtra(String extra) {
        extras.add(extra);
    }

    public void extendBooking(LocalDate newEndDate) {
        this.endDate = newEndDate;
        this.isExtended = true;
    }
}
