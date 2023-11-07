package case_study_2.furama_resort.controller;

import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Person;
import case_study_2.furama_resort.service.ICustomerService;
import case_study_2.furama_resort.service.ipml.CustomerService;

import java.util.List;

public class CustomerController {
    private final ICustomerService iCustomerService = new CustomerService();

    public List<Customer> getAll() {
        return iCustomerService.getAll();
    }

    public boolean checkObjectCode(String customerCode) {
        return iCustomerService.checkObjectCode(customerCode);
    }

    public void addObject(Person person1, Person person) {
        iCustomerService.addObject(person1, person);
    }

    public void editObject(Person person1, Person person) {
        iCustomerService.editObject(person1, person);
    }

    public void deleteObject(String customerCode) {
        iCustomerService.deleteObject(customerCode);
    }

    public List<Customer> searchObjectByName(String name) {
        return iCustomerService.searchObjectByName(name);
    }

    public boolean checkObjectNumberCmnd(String numberCMND) {
        return iCustomerService.checkObjectNumberCmnd(numberCMND);
    }

    public void editCustomerName(String customerCode, String name) {
        iCustomerService.editCustomerName(customerCode,name);
    }

    public void editCustomerNumberCmnd(String customerCode, String numberCmnd) {
        iCustomerService.editCustomerNumberCmnd(customerCode,numberCmnd);
    }

    public void editCustomerDateOfBirth(String customerCode, String dateOfBirth) {
        iCustomerService.editCustomerDateOfBirth(customerCode,dateOfBirth);
    }

    public void editCustomerGender(String customerCode, String gender) {
        iCustomerService.editCustomerGender(customerCode,gender);
    }

    public void editCustomerPhoneNumber(String customerCode, String phoneNumber) {
        iCustomerService.editCustomerPhoneNumber(customerCode,phoneNumber);
    }

    public void editCustomerEmai(String customerCode, String email) {
        iCustomerService.editCustomerEmai(customerCode,email);
    }

    public void editCustomerGuestType(String customerCode, String guestType, String address) {
        iCustomerService.editCustomerGuestType(customerCode, guestType,address);
    }
}
