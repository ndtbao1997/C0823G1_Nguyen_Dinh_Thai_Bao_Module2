package ss16_io_textfile.exec.copy_file_text;


import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    private static int count = 0;

    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        List<String> stringList = copyFileText.readFile(
                "src/ss16_io_textfile/exec/copy_file_text/name.txt");
        copyFileText.writeFile(
                "src/ss16_io_textfile/exec/copy_file_text/result.txt", stringList);
    }

    public List<String> readFile(String filePath) {
        List<String> strings = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);
                count += line.split("").length;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException ioException) {
                System.err.println(ioException.getMessage());
            }

        }
        return strings;
    }

    public void writeFile(String filePath, List<String> strings) {
        int totalCharacter;
        File file;
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(filePath);
            if (file.isFile()) {
                throw new FileAlreadyExistsException("Tên file đã tồn tại");
            }
            writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
            for (String string : strings) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            totalCharacter = count + (strings.size() - 1);
            System.out.println("Số kí tự trong tệp là: " + totalCharacter);
        } catch (FileAlreadyExistsException e) {
            System.err.println("File đã tồn tại");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                assert writer != null;
                writer.close();
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
