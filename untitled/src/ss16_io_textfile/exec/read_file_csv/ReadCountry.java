package ss16_io_textfile.exec.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadCountry {
    private static final List<Country> countryList = new ArrayList<>();

    public static void main(String[] args) {
        readFileCsv("src/ss16_io_textfile/exec/read_file_csv/countries.csv");
        for (Country countries : countryList) {
            System.out.println(countries);
        }
    }

    public static void readFileCsv(String fileBath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileBath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                createCountry(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File không tồn tại");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void createCountry(String line) {
        String[] inforCountry = line.split(",");
        int id;
        String code;
        String name;
        try {
            id = Integer.parseInt(inforCountry[0]);
            if (id < 1) {
                throw new InformationIsIncorrect("Số id không hợp lệ");
            }
            code = inforCountry[1];
            if (Objects.equals(code, "")) {
                throw new InformationIsIncorrect("Code không hợp lệ");
            }
            name = inforCountry[2];
            if (Objects.equals(name, "")) {
                throw new InformationIsIncorrect("Tên không hợp lệ");
            }
            countryList.add(new Country(id, code, name));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
