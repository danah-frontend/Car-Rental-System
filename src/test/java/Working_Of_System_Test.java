import org.example.Booking;
import org.example.Car;
import org.example.User;
import org.example.Working_Of_System;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Working_Of_System_Test {
    @Test
    void testBookCar() {
        // Создаем тестовые данные прямо в методе
        Working_Of_System bookingSystem = new Working_Of_System();
        User user = new User("U1", "Варвара");
        Car car = new Car("C1", "Toyota Corolla", 50.0);
        bookingSystem.addCar(car);

        LocalDate startDate = LocalDate.now().plusDays(1);
        LocalDate endDate = LocalDate.now().plusDays(3);

        Booking booking = bookingSystem.bookCar(user, car, startDate, endDate);

        assertNotNull(booking);
        assertEquals(user, booking.getUser());
        assertEquals(car, booking.getCar());
        assertEquals(startDate, booking.getStartDate());
        assertEquals(endDate, booking.getEndDate());
        assertFalse(car.isAvailable());
    }

    @Test
    void testGetUserBookings() {
        Working_Of_System bookingSystem = new Working_Of_System();
        User user = new User("U2", "Никита");
        Car car1 = new Car("C1", "Toyota Corolla", 50.0);
        Car car2 = new Car("C2", "Honda Civic", 45.0);
        bookingSystem.addCar(car1);
        bookingSystem.addCar(car2);

        LocalDate startDate1 = LocalDate.now().plusDays(1);
        LocalDate endDate1 = LocalDate.now().plusDays(2);
        bookingSystem.bookCar(user, car1, startDate1, endDate1);

        LocalDate startDate2 = LocalDate.now().plusDays(5);
        LocalDate endDate2 = LocalDate.now().plusDays(7);
        bookingSystem.bookCar(user, car2, startDate2, endDate2);

        List<Booking> userBookings = bookingSystem.getUserBookings(user);

        assertEquals(2, userBookings.size());
        assertEquals("Никита", userBookings.get(0).getUser().getName());
    }

    @Test
    void testAddExtras() {
        Working_Of_System bookingSystem = new Working_Of_System();
        User user = new User("U3", "Мария");
        Car car = new Car("C1", "Toyota Corolla", 50.0);
        bookingSystem.addCar(car);

        Booking booking = bookingSystem.bookCar(
                user, car,
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3)
        );

        bookingSystem.addExtraToBooking(booking, "Детское кресло");
        bookingSystem.addExtraToBooking(booking, "Навигатор");

        List<String> extras = booking.getExtras();

        assertEquals(2, extras.size());
        assertTrue(extras.contains("Детское кресло"));
        assertTrue(extras.contains("Навигатор"));
    }

    @Test
    void testExtendBooking() {
        Working_Of_System bookingSystem = new Working_Of_System();
        User user = new User("U4", "Сергей");
        Car car = new Car("C1", "Toyota Corolla", 50.0);
        bookingSystem.addCar(car);

        LocalDate startDate = LocalDate.now().plusDays(1);
        LocalDate endDate = LocalDate.now().plusDays(3);
        LocalDate newEndDate = LocalDate.now().plusDays(5);

        Booking booking = bookingSystem.bookCar(user, car, startDate, endDate);
        bookingSystem.extendBooking(booking, newEndDate);

        assertEquals(newEndDate, booking.getEndDate());
        assertTrue(booking.isExtended());
    }

    @Test
    void testSetLocations() {
        Working_Of_System bookingSystem = new Working_Of_System();
        User user = new User("U5", "Григорий");
        Car car = new Car("C1", "Toyota Corolla", 50.0);
        bookingSystem.addCar(car);

        Booking booking = bookingSystem.bookCar(
                user, car,
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3)
        );

        bookingSystem.setLocations(booking, "Аэропорт Шереметьево", "Аэропорт Домодедово");

        assertEquals("Аэропорт Шереметьево", booking.getPickupLocation());
        assertEquals("Аэропорт Домодедово", booking.getReturnLocation());
    }
}
