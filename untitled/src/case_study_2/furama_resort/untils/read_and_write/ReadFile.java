package case_study_2.furama_resort.untils.read_and_write;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String path) {
        List<String> strings = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
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
                System.err.println(e.getMessage());
            }
        }
        return strings;
    }
}
