package case_study_2.furama_resort.repository.impl;

import case_study_2.furama_resort.model.booking_contract.Booking;
import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.repository.IBookingRepository;
import case_study_2.furama_resort.untils.comparator.BookingComparator;
import case_study_2.furama_resort.untils.read_and_write.ReadFile;
import case_study_2.furama_resort.untils.read_and_write.WriteFile;

import java.util.*;
import java.util.regex.Pattern;

public class BookingRepository implements IBookingRepository {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_booking.csv";
    public void writeBooking(Set<Booking> bookingSet){
        List<Booking> bookingList = new ArrayList<>(bookingSet);
        WriteFile.WriteToFile(bookingList,PATH);
    }
    public static Set<Booking> getListBookingYear(List<Facility> facilityListYear) {
        Set<Booking> bookingSet = getBookingSet();
        Set<Booking> bookingSetNew = new TreeSet<>(new BookingComparator());
        for (Booking booking:bookingSet){
            for (Facility facility:facilityListYear){
                if (Objects.equals(booking.getFacilityCode(), facility.getServiceCode())){
                    bookingSetNew.add(booking);
                }
            }
        }
        return bookingSetNew;
    }

    public static Set<Booking> getBookingSet(){
        List<String> strings = ReadFile.readFile(PATH);
        String[] strings1;
        Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
        try{
            if (strings.isEmpty()){
                return bookingSet;
            }else {
                for (String str:strings){
                    strings1 = str.split(",");
                    bookingSet.add(new Booking(strings1[0],strings1[1],strings1[2],strings1[3],strings1[4],strings1[5]));
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignored){}
        return bookingSet;

    }
    @Override
    public void addObject(Booking booking) {
        Set<Booking> bookingSet = getBookingSet();
        bookingSet.add(booking);
        writeBooking(bookingSet);
    }

    @Override
    public Set<Booking> getAll() {
        return getBookingSet();
    }

    @Override
    public Queue<Booking> getBookingVillaAndHouse() {
        String serviceRegex = "^SV(VL|HO)-\\d{4}$";
        Set<Booking> bookingSet = getBookingSet();
        Queue<Booking> bookingQueue = new PriorityQueue<>();
        for (Booking booking: bookingSet){
            if (Pattern.matches(serviceRegex, booking.getFacilityCode())){
                bookingQueue.add(booking);
            }
        }
        return bookingQueue;
    }

    @Override
    public boolean checkObjectCode(String bookingCode) {
        Set<Booking> bookingSet = getBookingSet();
        for (Booking booking: bookingSet){
            if (Objects.equals(booking.getBookingCode(), bookingCode)){
                return true;
            }
        }
        return false;
    }
}
