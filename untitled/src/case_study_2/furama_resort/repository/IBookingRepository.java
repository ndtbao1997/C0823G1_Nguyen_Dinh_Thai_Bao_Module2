package case_study_2.furama_resort.repository;

import case_study_2.furama_resort.model.booking_contract.Booking;

import java.util.Queue;
import java.util.Set;

public interface IBookingRepository {
    void addObject(Booking booking);

    Set<Booking> getAll();

    Queue<Booking> getBookingVillaAndHouse();

    boolean checkObjectCode(String bookingCode);
}
