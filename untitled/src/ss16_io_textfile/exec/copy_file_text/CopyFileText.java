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
                "D:\\C0823G1_Nguyen_Dinh_Thai_Bao_Module1\\module_2\\untitled\\src\\ss16_io_textfile\\" +
                        "exec\\copy_file_text\\name.txt");
        copyFileText.writeFile(
                "D:\\C0823G1_Nguyen_Dinh_Thai_Bao_Module1\\module_2\\untitled\\src\\ss16_io_textfile\\" +
                        "exec\\copy_file_text\\result.txt", stringList);
    }
    public List<String> readFile(String filePath){
        List<String> strings = new ArrayList<>();
        try{
            File file = new File(filePath);
            if (!file.exists()) throw new FileNotFoundException();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null){
                strings.add(line);
                count += line.split("").length;
            }
            br.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return strings;
    }
    public void writeFile(String filePath, List<String> strings){
        try{
            File file = new File(filePath);
            if (file.isFile()) throw new FileAlreadyExistsException("Tên file đã tồn tại");
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < strings.size(); i++) {
                if (i == strings.size() -1) bufferedWriter.write(strings.get(i));
                else bufferedWriter.write(strings.get(i) + "\n");
            }
            bufferedWriter.close();
            System.out.println("Số kí tự trong tệp là: " + count);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
