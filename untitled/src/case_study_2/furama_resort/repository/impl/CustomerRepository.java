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
        for (Booking booking : bookingListYear) {
            for (Customer customer : customerList) {
                if (Objects.equals(customer.getCustomerCode(), booking.getCustomerCode())) {
                    newCustomer = new Customer(customer.getName(), customer.getDateOfBirth(), customer.getGender(),
                            customer.getNumberCMND(), customer.getPhoneNumber(), customer.getEmail(), customer.getCustomerCode(),
                            customer.getGuestType(), customer.getAddress(), booking.getDateBooking());
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
        if (strings.isEmpty()) {
            return customerList;
        } else {
            for (String s : strings) {
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
    public void addObject(Person person1, Person person) {
        List<Customer> customerList = getListCustomer();
        customerList.add(new Customer(person.getName(), person.getDateOfBirth(), person.getGender(), person.getNumberCMND(),
                person.getPhoneNumber(), person.getEmail(), ((Customer) person1).getCustomerCode(),
                ((Customer) person1).getGuestType(), ((Customer) person1).getAddress()));
        WriteFile.WriteToFile(customerList, PATH);
    }

    @Override
    public void editObject(Person person1, Person person) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer1 : customerList) {
            if (Objects.equals(customer1.getCustomerCode(), ((Customer) person1).getCustomerCode())) {
                customer1.setName(person.getName());
                customer1.setDateOfBirth(person.getDateOfBirth());
                customer1.setGender(person.getGender());
                customer1.setNumberCMND(person.getNumberCMND());
                customer1.setPhoneNumber(person.getPhoneNumber());
                customer1.setEmail(person.getEmail());
                customer1.setGuestType(((Customer) person1).getGuestType());
                customer1.setAddress(((Customer) person1).getAddress());
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }

    @Override
    public void deleteObject(String customerCode) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer : customerList) {
            if (Objects.equals(customer.getCustomerCode(), customerCode)) {
                customerList.remove(customer);
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }

    @Override
    public List<Customer> searchObjectByName(String name) {
        List<Customer> customerList = getListCustomer();
        List<Customer> newCustomerList = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                newCustomerList.add(customer);
            }
        }
        return newCustomerList;
    }

    @Override
    public boolean checkObjectNumberCmnd(String numberCMND) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer: customerList){
            if (Objects.equals(customer.getNumberCMND(), numberCMND)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void editCustomerName(String customerCode, String name) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer: customerList){
            if (Objects.equals(customer.getCustomerCode(), customerCode)){
                customer.setName(name);
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }

    @Override
    public void editCustomerNumberCmnd(String customerCode, String numberCmnd) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer: customerList){
            if (Objects.equals(customer.getCustomerCode(), customerCode)){
                customer.setNumberCMND(numberCmnd);
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }

    @Override
    public void editCustomerDateOfBirth(String customerCode, String dateOfBirth) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer: customerList){
            if (Objects.equals(customer.getCustomerCode(), customerCode)){
                customer.setDateOfBirth(dateOfBirth);
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }

    @Override
    public void editCustomerGender(String customerCode, String gender) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer: customerList){
            if (Objects.equals(customer.getCustomerCode(), customerCode)){
                customer.setGender(gender);
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }

    @Override
    public void editCustomerPhoneNumber(String customerCode, String phoneNumber) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer: customerList){
            if (Objects.equals(customer.getCustomerCode(), customerCode)){
                customer.setPhoneNumber(phoneNumber);
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }

    @Override
    public void editCustomerEmai(String customerCode, String email) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer: customerList){
            if (Objects.equals(customer.getCustomerCode(), customerCode)){
                customer.setEmail(email);
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }

    @Override
    public void editCustomerGuestType(String customerCode, String guestType, String address) {
        List<Customer> customerList = getListCustomer();
        for (Customer customer: customerList){
            if (Objects.equals(customer.getCustomerCode(), customerCode)){
                customer.setGuestType(guestType);
                customer.setAddress(address);
                WriteFile.WriteToFile(customerList, PATH);
                return;
            }
        }
    }
}
