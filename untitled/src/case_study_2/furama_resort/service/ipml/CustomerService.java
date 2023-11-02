package case_study_2.furama_resort.service.ipml;

import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Person;
import case_study_2.furama_resort.repository.ICustomerRepository;
import case_study_2.furama_resort.repository.impl.CustomerRepository;
import case_study_2.furama_resort.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {

    private final ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public boolean checkObjectCode(String customerCode) {
        return iCustomerRepository.checkObjectCode(customerCode);
    }

    @Override
    public void addObject(Customer customer, Person person) {
        iCustomerRepository.addObject(customer,person);
    }

    @Override
    public void editObject(Customer customer, Person person) {
        iCustomerRepository.editObject(customer,person);
    }

    @Override
    public void deleteObject(String customerCode) {
        iCustomerRepository.deleteObject(customerCode);
    }

    @Override
    public List<Customer> searchObjectByName(String name) {
        return iCustomerRepository.searchObjectByName(name);
    }
}
