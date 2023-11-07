package case_study_2.furama_resort.controller;


import case_study_2.furama_resort.model.person.Employee;
import case_study_2.furama_resort.model.person.Person;
import case_study_2.furama_resort.service.IEmployeeService;
import case_study_2.furama_resort.service.ipml.EmployeeService;

import java.util.List;

public class EmployeeController {
    private final IEmployeeService iEmployeeService = new EmployeeService();

    public List<Employee> getAll() {
        return iEmployeeService.getAll();
    }

    public void addObject(Person person1, Person person) {
        iEmployeeService.addObject(person1, person);
    }

    public boolean checkObjectCode(String employeeCode) {
        return iEmployeeService.checkObjectCode(employeeCode);
    }

    public void editObject(Person person1, Person person) {
        iEmployeeService.editObject(person1, person);
    }

    public void deleteObject(String employeeCode) {
        iEmployeeService.deleteObject(employeeCode);
    }

    public List<Employee> searchObjectByName(String name) {
        return iEmployeeService.searchObjectByName(name);
    }

    public boolean checkObjectNumberCmnd(String numberCMND) {
        return iEmployeeService.checkObjectNumberCmnd(numberCMND);
    }

    public void editEmployeeName(String employeeCode, String name) {
        iEmployeeService.editEmployeeName(employeeCode, name);
    }

    public void editEmployeeDateOfBirth(String employeeCode, String dateOfBirth) {
        iEmployeeService.editEmployeeDateOfBirth(employeeCode,dateOfBirth);
    }

    public void editEmployeeGender(String employeeCode, String gender) {
        iEmployeeService.editEmployeeGender(employeeCode,gender);
    }

    public void editEmployeeNumberCmnd(String employeeCode, String numberCmnd) {
        iEmployeeService.editEmployeeNumberCmnd(employeeCode,numberCmnd);
    }

    public void editEmployeePhoneNumber(String employeeCode, String phoneNumber) {
        iEmployeeService.editEmployeePhoneNumber(employeeCode,phoneNumber);
    }

    public void editEmployeeMail(String employeeCode, String email) {
        iEmployeeService.editEmployeeMail(employeeCode, email);
    }

    public void editEmployeeLevel(String employeeCode, String level) {
        iEmployeeService.editEmployeeLevel(employeeCode,level);
    }

    public void editEmployeeLocation(String employeeCode, String location) {
        iEmployeeService.editEmployeeLocation(employeeCode,location);
    }

    public void editEmployeeWage(String employeeCode, Integer wage) {
        iEmployeeService.editEmployeeWage(employeeCode,wage);
    }
}
