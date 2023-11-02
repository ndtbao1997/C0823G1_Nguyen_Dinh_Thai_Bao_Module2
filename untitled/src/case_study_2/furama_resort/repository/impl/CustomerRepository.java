package case_study_2.furama_resort.repository.impl;

import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Person;
import case_study_2.furama_resort.repository.ICustomerRepository;
import case_study_2.furama_resort.untils.read_and_write.ReadFileCustomer;
import case_study_2.furama_resort.untils.read_and_write.WriteFileCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerRepository implements ICustomerRepository {
    public List<Customer> getListCustomer() {
        List<Customer> customerList = new ArrayList<>();
        if (ReadFileCustomer.checkData()) {
            return ReadFileCustomer.readFile();
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
        WriteFileCustomer.writeToFile(customerList);
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
                WriteFileCustomer.writeToFile(customerList);
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
                WriteFileCustomer.writeToFile(customerList);
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
