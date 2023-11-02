package case_study_2.furama_resort.untils.read_and_write;

import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.facility.House;
import case_study_2.furama_resort.model.facility.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFileFacility {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_facility.csv";

    public static Map<Facility, Integer> readFile() {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] strings;
        Facility facility;
        try {
            fileReader = new FileReader(PATH);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                strings = line.split(",");
                if (strings.length == 10) {
                    facility = new Villa(strings[0], strings[1], Double.parseDouble(strings[2]),
                            Double.parseDouble(strings[3]), Integer.parseInt(strings[4]), strings[5], strings[6],
                            Integer.parseInt(strings[7]), Double.parseDouble(strings[8]));
                    facilityIntegerMap.put(facility, Integer.parseInt(strings[9]));
                }
                if (strings.length == 9) {
                    facility = new House(strings[0], strings[1], Double.parseDouble(strings[2]),
                            Double.parseDouble(strings[3]), Integer.parseInt(strings[4]), strings[5], strings[6],
                            Integer.parseInt(strings[7]));
                    facilityIntegerMap.put(facility, Integer.parseInt(strings[8]));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (IndexOutOfBoundsException ignored) {
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
                assert bufferedReader != null;
                bufferedReader.close();
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
        }
        return facilityIntegerMap;
    }


}
