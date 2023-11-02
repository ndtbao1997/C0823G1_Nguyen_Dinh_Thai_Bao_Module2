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

    public void addObject(Employee employee, Person person) {
        iEmployeeService.addObject(employee, person);
    }

    public boolean checkObjectCode(String employeeCode) {
        return iEmployeeService.checkObjectCode(employeeCode);
    }

    public void editObject(Employee employee, Person person) {
        iEmployeeService.editObject(employee,person);
    }

    public void deleteObject(String employeeCode) {
        iEmployeeService.deleteObject(employeeCode);
    }

    public List<Employee> searchObjectByName(String name) {
        return iEmployeeService.searchObjectByName(name);
    }
}
