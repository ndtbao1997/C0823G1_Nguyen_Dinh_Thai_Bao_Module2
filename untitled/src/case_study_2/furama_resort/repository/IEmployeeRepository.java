package case_study_2.furama_resort.repository;

import case_study_2.furama_resort.model.person.Employee;
import case_study_2.furama_resort.model.person.Person;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getAll();

    void addObject(Person person1, Person person);

    boolean checkObjectCode(String employeeCode);

    void editObject(Person person1, Person person);

    void deleteObject(String employeeCode);

    List<Employee> searchObjectByName(String name);

    boolean checkObjectNumberCmnd(String numberCMND);

    void editEmployeeName(String employeeCode, String name);

    void editEmployeeDateOfBirth(String employeeCode, String dateOfBirth);

    void editEmployeeGender(String employeeCode, String gender);

    void editEmployeeNumberCmnd(String employeeCode, String numberCmnd);

    void editEmployeePhoneNumber(String employeeCode, String phoneNumber);

    void editEmployeeMail(String employeeCode, String email);

    void editEmployeeLevel(String employeeCode, String level);

    void editEmployeeLocation(String employeeCode, String location);

    void editEmployeeWage(String employeeCode, Integer wage);
}
