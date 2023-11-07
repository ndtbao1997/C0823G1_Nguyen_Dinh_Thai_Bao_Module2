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

    public List<Employee> getListEmployee() {
        List<String> strings = ReadFile.readFile(PATH);
        String[] stringArr;
        Employee employee;
        List<Employee> employeeList = new ArrayList<>();
        if (strings.isEmpty()) {
            return employeeList;
        } else {
            for (String s : strings) {
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
    public void addObject(Person person1, Person person) {
        List<Employee> employeeList = getListEmployee();
        employeeList.add(new Employee(person.getName(), person.getDateOfBirth(), person.getGender(),
                person.getNumberCMND(), person.getPhoneNumber(), person.getEmail(),
                ((Employee) person1).getEmployeeCode(), ((Employee) person1).getLevel(),
                ((Employee) person1).getLocation(), ((Employee) person1).getWage()));
        WriteFile.WriteToFile(employeeList, PATH);
    }

    @Override
    public boolean checkObjectCode(String employeeCode) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void editObject(Person person1, Person person) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee1 : employeeList) {
            if (Objects.equals(employee1.getEmployeeCode(), ((Employee) person1).getEmployeeCode())) {
                employee1.setName(person.getName());
                employee1.setDateOfBirth(person.getDateOfBirth());
                employee1.setGender(person.getGender());
                employee1.setNumberCMND(person.getNumberCMND());
                employee1.setPhoneNumber(person.getPhoneNumber());
                employee1.setEmail(person.getEmail());
                employee1.setLevel(((Employee) person1).getLevel());
                employee1.setLocation(((Employee) person1).getLocation());
                employee1.setWage(((Employee) person1).getWage());
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void deleteObject(String employeeCode) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)) {
                employeeList.remove(employee);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public List<Employee> searchObjectByName(String name) {
        List<Employee> employeeList = getListEmployee();
        List<Employee> newEmployeeList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                newEmployeeList.add(employee);
            }
        }
        return newEmployeeList;
    }

    @Override
    public boolean checkObjectNumberCmnd(String numberCMND) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getNumberCMND(), numberCMND)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void editEmployeeName(String employeeCode, String name) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setName(name);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void editEmployeeDateOfBirth(String employeeCode, String dateOfBirth) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setDateOfBirth(dateOfBirth);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void editEmployeeGender(String employeeCode, String gender) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setGender(gender);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void editEmployeeNumberCmnd(String employeeCode, String numberCmnd) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setNumberCMND(numberCmnd);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void editEmployeePhoneNumber(String employeeCode, String phoneNumber) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setPhoneNumber(phoneNumber);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void editEmployeeMail(String employeeCode, String email) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setEmail(email);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void editEmployeeLevel(String employeeCode, String level) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setLevel(level);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void editEmployeeLocation(String employeeCode, String location) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setLocation(location);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }

    @Override
    public void editEmployeeWage(String employeeCode, Integer wage) {
        List<Employee> employeeList = getListEmployee();
        for (Employee employee:employeeList){
            if (Objects.equals(employee.getEmployeeCode(), employeeCode)){
                employee.setWage(wage);
                WriteFile.WriteToFile(employeeList, PATH);
                return;
            }
        }
    }
}
