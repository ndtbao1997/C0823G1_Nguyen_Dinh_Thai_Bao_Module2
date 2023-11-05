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
    public void addObject(Person person1, Person person) {
        iCustomerRepository.addObject(person1, person);
    }

    @Override
    public void editObject(Person person1, Person person) {
        iCustomerRepository.editObject(person1, person);
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
