package case_study_2.furama_resort.service;

import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Person;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();

    boolean checkObjectCode(String customerCode);

    void addObject(Person person1, Person person);

    void editObject(Person person1, Person person);

    void deleteObject(String customerCode);

    List<Customer> searchObjectByName(String name);

    boolean checkObjectNumberCmnd(String numberCMND);

    void editCustomerName(String customerCode, String name);

    void editCustomerNumberCmnd(String customerCode, String numberCmnd);

    void editCustomerDateOfBirth(String customerCode, String dateOfBirth);

    void editCustomerGender(String customerCode, String gender);

    void editCustomerPhoneNumber(String customerCode, String phoneNumber);

    void editCustomerEmai(String customerCode, String email);

    void editCustomerGuestType(String customerCode, String guestType, String address);
}
