package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Working_Of_System {
    private List<Car> cars;
    private List<Booking> bookings;

    public Working_Of_System() {
        this.cars = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    // Бронирование автомобиля (User Story 1)
    public Booking bookCar(User user, Car car, LocalDate startDate, LocalDate endDate) {
        if (!car.isAvailable()) {
            throw new IllegalStateException("Машина недоступна");
        }

        Booking booking = new Booking("B" + (bookings.size() + 1), user, car, startDate, endDate);
        car.setAvailable(false);
        bookings.add(booking);
        return booking;
    }

    // Получение истории бронирований пользователя (User Story 2)
    public List<Booking> getUserBookings(User user) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getUser().getId().equals(user.getId())) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }

    // Добавление дополнительных опций (User Story 3)
    public void addExtraToBooking(Booking booking, String extra) {
        booking.addExtra(extra);
    }

    // Продление бронирования (User Story 4)
    public void extendBooking(Booking booking, LocalDate newEndDate) {
        booking.extendBooking(newEndDate);
    }

    // Установка места получения и возврата (User Story 5)
    public void setLocations(Booking booking, String pickupLocation, String returnLocation) {
        booking.setPickupLocation(pickupLocation);
        booking.setReturnLocation(returnLocation);
    }
}
