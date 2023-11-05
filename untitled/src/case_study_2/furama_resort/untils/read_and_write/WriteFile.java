package case_study_2.furama_resort.untils.read_and_write;

import java.io.*;
import java.util.List;

public class WriteFile {
    public static <E> void WriteToFile(List<E> eList, String path) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E e : eList) {
                bufferedWriter.write(e.toString());
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
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
