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
    public void addObject(Employee employee, Person person) {
        iEmployeeRepository.addObject(employee, person);
    }

    @Override
    public boolean checkObjectCode(String employeeCode) {
        return iEmployeeRepository.checkObjectCode(employeeCode);
    }

    @Override
    public void editObject(Employee employee, Person person) {
        iEmployeeRepository.editObject(employee,person);
    }

    @Override
    public void deleteObject(String employeeCode) {
        iEmployeeRepository.deleteObject(employeeCode);
    }

    @Override
    public List<Employee> searchObjectByName(String name) {
        return iEmployeeRepository.searchObjectByName(name);
    }


}
