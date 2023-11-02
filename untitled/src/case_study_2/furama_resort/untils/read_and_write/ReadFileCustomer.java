package case_study_2.furama_resort.untils.read_and_write;

import case_study_2.furama_resort.model.person.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCustomer {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_customer.csv";

    public static List<Customer> readFile() {
        List<Customer> customerList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(PATH);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            Customer customer;
            String[] strings;
            while ((line = bufferedReader.readLine()) != null) {
                strings = line.split(",");
                customer = new Customer(strings[0], strings[1], strings[2], strings[3], strings[4],
                        strings[5], strings[6], strings[7], strings[8]);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file");
        } catch (IndexOutOfBoundsException ignored) {

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return customerList;
    }
    public static boolean checkData(){
        File file = new File(PATH);
        return file.canRead();
    }
}
