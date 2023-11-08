package case_study_2.furama_resort.controller;

import case_study_2.furama_resort.model.booking_contract.Booking;
import case_study_2.furama_resort.service.IBookingService;
import case_study_2.furama_resort.service.ipml.BookingService;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BookingController {
    private final IBookingService iBookingService = new BookingService();

    public void addObject(Booking booking) {
        iBookingService.addObject(booking);
    }

    public Set<Booking> getAll() {
        return iBookingService.getAll();
    }

    public Queue<Booking> getBookingVillaAndHouse() {
        return iBookingService.getBookingVillaAndHouse();
    }

    public boolean checkObjectCode(String bookingCode) {
        return iBookingService.checkObjectCode(bookingCode);
    }

    public boolean checkFacilityCode(String facilityCode) {
        return iBookingService.checkFacilityCode(facilityCode);
    }

    public List<String> getInforBooking(String bookingCode) {
        return iBookingService.getInforBooking(bookingCode);
    }
}
