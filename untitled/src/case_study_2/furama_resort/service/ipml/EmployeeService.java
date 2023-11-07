package case_study_2.furama_resort.service.ipml;

import case_study_2.furama_resort.model.person.Employee;
import case_study_2.furama_resort.model.person.Person;
import case_study_2.furama_resort.repository.impl.EmployeeReporitory;
import case_study_2.furama_resort.repository.IEmployeeRepository;
import case_study_2.furama_resort.service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository iEmployeeRepository = new EmployeeReporitory();

    @Override
    public List<Employee> getAll() {
        return iEmployeeRepository.getAll();
    }


    @Override
    public void addObject(Person person1, Person person) {
        iEmployeeRepository.addObject(person1, person);
    }

    @Override
    public boolean checkObjectCode(String employeeCode) {
        return iEmployeeRepository.checkObjectCode(employeeCode);
    }

    @Override
    public void editObject(Person person1, Person person) {
        iEmployeeRepository.editObject(person1, person);
    }

    @Override
    public void deleteObject(String employeeCode) {
        iEmployeeRepository.deleteObject(employeeCode);
    }

    @Override
    public List<Employee> searchObjectByName(String name) {
        return iEmployeeRepository.searchObjectByName(name);
    }

    @Override
    public boolean checkObjectNumberCmnd(String numberCMND) {
        return iEmployeeRepository.checkObjectNumberCmnd(numberCMND);
    }

    @Override
    public void editEmployeeName(String employeeCode, String name) {
        iEmployeeRepository.editEmployeeName(employeeCode, name);
    }

    @Override
    public void editEmployeeDateOfBirth(String employeeCode, String dateOfBirth) {
        iEmployeeRepository.editEmployeeDateOfBirth(employeeCode,dateOfBirth);
    }

    @Override
    public void editEmployeeGender(String employeeCode, String gender) {
        iEmployeeRepository.editEmployeeGender(employeeCode,gender);
    }

    @Override
    public void editEmployeeNumberCmnd(String employeeCode, String numberCmnd) {
        iEmployeeRepository.editEmployeeNumberCmnd(employeeCode,numberCmnd);
    }

    @Override
    public void editEmployeePhoneNumber(String employeeCode, String phoneNumber) {
        iEmployeeRepository.editEmployeePhoneNumber(employeeCode,phoneNumber);
    }

    @Override
    public void editEmployeeMail(String employeeCode, String email) {
        iEmployeeRepository.editEmployeeMail(employeeCode, email);
    }

    @Override
    public void editEmployeeLevel(String employeeCode, String level) {
        iEmployeeRepository.editEmployeeLevel(employeeCode,level);
    }

    @Override
    public void editEmployeeLocation(String employeeCode, String location) {
        iEmployeeRepository.editEmployeeLocation(employeeCode,location);
    }

    @Override
    public void editEmployeeWage(String employeeCode, Integer wage) {
        iEmployeeRepository.editEmployeeWage(employeeCode,wage);
    }


}
