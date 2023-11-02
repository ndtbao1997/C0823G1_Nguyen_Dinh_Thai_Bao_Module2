package case_study_2.furama_resort.controller;

import case_study_2.furama_resort.repository.IBookingRepository;
import case_study_2.furama_resort.repository.impl.BookingRepository;

import java.util.List;

public class BookingController {
    private final IBookingRepository iBookingRepository = new BookingRepository();

}
