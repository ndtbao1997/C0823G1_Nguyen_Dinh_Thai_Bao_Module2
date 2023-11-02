package case_study_2.furama_resort.service;

import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Person;

import java.util.List;

public interface ICustomerService{
    List<Customer> getAll();

    boolean checkObjectCode(String customerCode);

    void addObject(Customer customer, Person person);

    void editObject(Customer customer, Person person);

    void deleteObject(String customerCode);

    List<Customer> searchObjectByName(String name);
}
