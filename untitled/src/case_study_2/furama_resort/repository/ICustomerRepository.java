package case_study_2.furama_resort.repository;

import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Person;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();

    boolean checkObjectCode(String customerCode);

    void addObject(Person person1, Person person);

    void editObject(Person person1, Person person);

    void deleteObject(String customerCode);

    List<Customer> searchObjectByName(String name);
}
