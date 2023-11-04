package case_study_2.furama_resort.repository.impl;

import case_study_2.furama_resort.model.person.Employee;
import case_study_2.furama_resort.model.person.Person;
import case_study_2.furama_resort.repository.IEmployeeRepository;
import case_study_2.furama_resort.untils.read_and_write.ReadFile;
import case_study_2.furama_resort.untils.read_and_write.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeReporitory implements IEmployeeRepository {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_employee.csv";
    public List<Employee> getListEmployee(){
        List<String> strings = ReadFile.readFile(PATH);
        String[] stringArr;
        Employee employee;
        List<Employee> employeeList = new ArrayList<>();
        if (strings.isEmpty()){
            return  employeeList;
        } else {
            for (String s:strings){
                stringArr = s.split(",");
                employee = new Employee(stringArr[0], stringArr[1], stringArr[2], stringArr[3], stringArr[4],
                        stringArr[5], stringArr[6], stringArr[7], stringArr[8], Integer.parseInt(stringArr[9]));
                employeeList.add(employee);
            }
        }
        return employeeList;
    }


    @Override
    public List<Employee> getAll() {
        return getListEmployee();
    }

    @Override
    public void addObject(Employee employee, Person person) {
        List<Employee> employeeList = getListEmployee();
        employeeList.add(new Employee(person.getName(), person.getDateOfBirth(), person.getGender(),
                person.getNumberCMND(), person.getPhoneNumber(), person.getEmail(),
                employee.getEmployeeCode(), employee.getLevel(), employee.getLocation(), employee.getWage()));
        WriteFile.WriteToFile(employeeList,PATH);
    }

    @Override
    public boolean checkObjectCode(String employeeCode) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee: employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void editObject(Employee employee, Person person) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee1: employeeList){
            if (Objects.equals(employee1.getEmployeeCode(), employee.getEmployeeCode())){
                employee1.setName(person.getName());
                employee1.setDateOfBirth(person.getDateOfBirth());
                employee1.setGender(person.getGender());
                employee1.setNumberCMND(person.getNumberCMND());
                employee1.setPhoneNumber(person.getPhoneNumber());
                employee1.setEmail(person.getEmail());
                employee1.setLevel(employee.getLevel());
                employee1.setLocation(employee.getLocation());
                employee1.setWage(employee.getWage());
                WriteFile.WriteToFile(employeeList,PATH);
                return;
            }
        }
    }

    @Override
    public void deleteObject(String employeeCode) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employeeList.remove(employee);
                WriteFile.WriteToFile(employeeList,PATH);
                return;
            }
        }
    }

    @Override
    public List<Employee> searchObjectByName(String name) {
        List<Employee> employeeList = getListEmployee();
        List<Employee> newEmployeeList = new ArrayList<>();
        for (Employee employee: employeeList){
            if (employee.getName().toLowerCase().contains(name.toLowerCase())){
                newEmployeeList.add(employee);
            }
        }
        return newEmployeeList;
    }
}
