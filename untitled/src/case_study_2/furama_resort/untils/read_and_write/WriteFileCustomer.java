package case_study_2.furama_resort.untils.read_and_write;

import case_study_2.furama_resort.model.person.Customer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileCustomer {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_customer.csv";

    public static void writeToFile(List<Customer> customerList) {
        File file = new File(PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.getName() + "," + customer.getDateOfBirth() + "," + customer.getGender() + "," +
                        customer.getNumberCMND() + "," + customer.getPhoneNumber() + "," + customer.getEmail() + "," +
                        customer.getCustomerCode() + "," + customer.getGuestType() + "," + customer.getAddress());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try{
                assert fileWriter != null;
                fileWriter.close();
                assert bufferedWriter != null;
                bufferedWriter.close();
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
