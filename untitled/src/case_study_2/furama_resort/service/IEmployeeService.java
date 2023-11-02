package case_study_2.furama_resort.service;

import case_study_2.furama_resort.model.person.Employee;
import case_study_2.furama_resort.model.person.Person;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    void addObject(Employee employee, Person person);

    boolean checkObjectCode(String employeeCode);

    void editObject(Employee employee, Person person);

    void deleteObject(String employeeCode);

    List<Employee> searchObjectByName(String name);
}
