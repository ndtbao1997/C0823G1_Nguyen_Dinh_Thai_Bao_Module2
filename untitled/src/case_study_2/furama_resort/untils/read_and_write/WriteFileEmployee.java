package case_study_2.furama_resort.untils.read_and_write;

import case_study_2.furama_resort.model.person.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileEmployee {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_employee.csv";

    public static void writeToFile(List<Employee> employees) {
        File file = new File(PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employees) {
                bufferedWriter.write(employee.getName() + "," + employee.getDateOfBirth() + "," + employee.getGender() +
                        "," + employee.getNumberCMND() + "," + employee.getPhoneNumber() + "," + employee.getEmail() +
                        "," + employee.getEmployeeCode() + "," + employee.getLevel() + "," + employee.getLocation() +
                        "," + employee.getWage());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
