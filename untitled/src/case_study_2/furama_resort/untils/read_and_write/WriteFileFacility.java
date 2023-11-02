package case_study_2.furama_resort.untils.read_and_write;

import case_study_2.furama_resort.model.facility.Facility;
import case_study_2.furama_resort.model.facility.House;
import case_study_2.furama_resort.model.facility.Villa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class WriteFileFacility {
    private static final String PATH = "src/case_study_2/furama_resort/data/data_facility.csv";

    public static void writeTofile(Map<Facility, Integer> facilityIntegerMap) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        Set<Facility> keySet = facilityIntegerMap.keySet();
        try {
            fileWriter = new FileWriter(PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Facility key : keySet) {
                if (key instanceof Villa) {
                    bufferedWriter.write(key.getServiceCode() + "," + key.getServiceName() + "," + key.getUsableArea() + "," +
                            key.getRentalCosts() + "," + key.getMaxPeople() + "," + key.getRentalType() + "," + ((Villa) key).getRoomStandards() + "," +
                            ((Villa) key).getNumberOfFloors() + "," + ((Villa) key).getSwimmingPoolArea() + "," + facilityIntegerMap.get(key));
                    bufferedWriter.newLine();
                } else if (key instanceof House) {
                    bufferedWriter.write(key.getServiceCode() + "," + key.getServiceName() + "," + key.getUsableArea() + "," +
                            key.getRentalCosts() + "," + key.getMaxPeople() + "," + key.getRentalType() + "," + ((House) key).getRoomStandards() + "," +
                            ((House) key).getNumberOfFloors() + "," + facilityIntegerMap.get(key));
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
