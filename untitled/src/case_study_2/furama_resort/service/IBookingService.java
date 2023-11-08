package case_study_2.furama_resort.service;

import case_study_2.furama_resort.model.booking_contract.Booking;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public interface IBookingService {
    void addObject(Booking booking);

    Set<Booking> getAll();

    Queue<Booking> getBookingVillaAndHouse();

    boolean checkObjectCode(String bookingCode);

    boolean checkFacilityCode(String facilityCode);

    List<String> getInforBooking(String bookingCode);
}
