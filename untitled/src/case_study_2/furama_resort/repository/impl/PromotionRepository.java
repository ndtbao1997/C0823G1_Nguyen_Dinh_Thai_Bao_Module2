package case_study_2.furama_resort.repository.impl;

import case_study_2.furama_resort.model.booking_contract.Booking;
import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.repository.IPromotionRepository;

import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PromotionRepository implements IPromotionRepository {

    @Override
    public Set<Customer> getCustomerPromotion() {
        List<Facility> facilityListYear = FacilityRepository.getListFacilityYear();
        Set<Booking> bookingListYear = BookingRepository.getListBookingYear(facilityListYear);
        return CustomerRepository.getListCustomerBookingYear(bookingListYear);
    }

    @Override
    public Stack<Customer> getStackCustomer() {
        Set<Customer> customerSet = getCustomerPromotion();
        Stack<Customer> customerStack = new Stack<>();
        for (Customer customer :customerSet){
            customerStack.push(customer);
        }
        return customerStack;
    }
}
