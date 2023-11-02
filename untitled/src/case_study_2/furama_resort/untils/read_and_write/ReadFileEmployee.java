package case_study_2.furama_resort.untils.read_and_write;

import case_study_2.furama_resort.model.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileEmployee {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_employee.csv";

    public static List<Employee> readFile() {
        List<Employee> employeeList = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            FileReader fileReader = new FileReader(PATH);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            Employee employee;
            String[] strings;
            while ((line = bufferedReader.readLine()) != null) {
                strings = line.split(",");
                employee = new Employee(strings[0], strings[1], strings[2], strings[3], strings[4],
                        strings[5], strings[6], strings[7], strings[8], Integer.parseInt(strings[9]));
                employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file");
        } catch (IndexOutOfBoundsException ignored) {
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return employeeList;
    }

    public static boolean checkData() {
        File file = new File(PATH);
        return file.canRead();
    }
}
