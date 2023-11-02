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

    public void addObject(Customer customer, Person person) {
        iCustomerService.addObject(customer,person);
    }

    public void editObject(Customer customer, Person person) {
        iCustomerService.editObject(customer,person);
    }

    public void deleteObject(String customerCode) {
        iCustomerService.deleteObject(customerCode);
    }

    public List<Customer> searchObjectByName(String name) {
        return iCustomerService.searchObjectByName(name);
    }
}
