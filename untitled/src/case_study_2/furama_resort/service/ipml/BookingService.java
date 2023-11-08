package case_study_2.furama_resort.service.ipml;

import case_study_2.furama_resort.model.booking_contract.Booking;
import case_study_2.furama_resort.repository.IBookingRepository;
import case_study_2.furama_resort.repository.impl.BookingRepository;
import case_study_2.furama_resort.service.IBookingService;

import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BookingService implements IBookingService {
    private final IBookingRepository iBookingRepository = new BookingRepository();

    @Override
    public void addObject(Booking booking) {
        iBookingRepository.addObject(booking);
    }

    @Override
    public Set<Booking> getAll() {
        return iBookingRepository.getAll();
    }

    @Override
    public Queue<Booking> getBookingVillaAndHouse() {
        return iBookingRepository.getBookingVillaAndHouse();
    }

    @Override
    public boolean checkObjectCode(String bookingCode) {
        return iBookingRepository.checkObjectCode(bookingCode);
    }

    @Override
    public boolean checkFacilityCode(String facilityCode) {
        return iBookingRepository.checkFacilityCode(facilityCode);
    }

    @Override
    public List<String> getInforBooking(String bookingCode) {
        return iBookingRepository.getInforBooking(bookingCode);
    }
}
