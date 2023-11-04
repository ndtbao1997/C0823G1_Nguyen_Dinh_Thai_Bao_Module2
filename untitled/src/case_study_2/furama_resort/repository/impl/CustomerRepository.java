package case_study_2.furama_resort.repository.impl;

import case_study_2.furama_resort.model.booking_contract.Booking;
import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Person;
import case_study_2.furama_resort.repository.ICustomerRepository;
import case_study_2.furama_resort.untils.comparator.PromotionComparator;
import case_study_2.furama_resort.untils.read_and_write.ReadFile;
import case_study_2.furama_resort.untils.read_and_write.WriteFile;


import java.util.*;

public class CustomerRepository implements ICustomerRepository {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_customer.csv";
    public static Set<Customer> getListCustomerBookingYear(Set<Booking> bookingListYear) {
        List<Customer> customerList = getListCustomer();
        Customer newCustomer;
        Set<Customer> customerSet = new TreeSet<>(new PromotionComparator());
        for (Booking booking:bookingListYear){
            for (Customer customer:customerList){
                if (Objects.equals(customer.getCustomerCode(), booking.getCustomerCode())){
                    newCustomer = new Customer(customer.getName(),customer.getDateOfBirth(),customer.getGender(),
                            customer.getNumberCMND(), customer.getPhoneNumber(), customer.getEmail(), customer.getCustomerCode(),
                            customer.getGuestType(), customer.getAddress(),booking.getDateBooking());
                    customerSet.add(newCustomer);
                }
            }
        }
        return customerSet;
    }

    public static List<Customer> getListCustomer() {
        List<String> strings = ReadFile.readFile(PATH);
        List<Customer> customerList = new ArrayList<>();
        String[] stringArr;
        Customer customer;
        if (strings.isEmpty()){
            return customerList;
        } else {
            for (String s:strings){
                stringArr = s.split(",");
                customer = new Customer(stringArr[0], stringArr[1], stringArr[2], stringArr[3], stringArr[4],
                        stringArr[5], stringArr[6], stringArr[7], stringArr[8]);
                customerList.add(customer);
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> getAll() {
        return getListCustomer();
    }

    @Override
    public boolean checkObjectCode(String customerCode) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer : customerList) {
            if (Objects.equals(customer.getCustomerCode(), customerCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addObject(Customer customer, Person person) {
        List<Customer> customerList = getListCustomer();
        customerList.add(new Customer(person.getName(), person.getDateOfBirth(), person.getGender(), person.getNumberCMND(),
                person.getPhoneNumber(), person.getEmail(), customer.getCustomerCode(),
                customer.getGuestType(), customer.getAddress()));
        WriteFile.WriteToFile(customerList,PATH);
    }

    @Override
    public void editObject(Customer customer, Person person) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer1:customerList){
            if (Objects.equals(customer1.getCustomerCode(), customer.getCustomerCode())){
                customer1.setName(person.getName());
                customer1.setDateOfBirth(person.getDateOfBirth());
                customer1.setGender(person.getGender());
                customer1.setNumberCMND(person.getNumberCMND());
                customer1.setPhoneNumber(person.getPhoneNumber());
                customer1.setEmail(person.getEmail());
                customer1.setGuestType(customer.getGuestType());
                customer1.setAddress(customer.getAddress());
                WriteFile.WriteToFile(customerList,PATH);
                return;
            }
        }
    }

    @Override
    public void deleteObject(String customerCode) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer:customerList){
            if (Objects.equals(customer.getCustomerCode(), customerCode)){
                customerList.remove(customer);
                WriteFile.WriteToFile(customerList,PATH);
                return;
            }
        }
    }

    @Override
    public List<Customer> searchObjectByName(String name) {
        List<Customer> customerList = getListCustomer();
        List<Customer> newCustomerList = new ArrayList<>();
        for (Customer customer:customerList){
            if (customer.getName().toLowerCase().contains(name.toLowerCase())){
                newCustomerList.add(customer);
            }
        }
        return newCustomerList;
    }
}
