package ss17_io_binary_file_serialization.exec.product_manager_binary_file.utils.read_and_write;

import ss17_io_binary_file_serialization.exec.product_manager_binary_file.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadProducts {
    private static final String FILEBATH =
            "src/ss17_io_binary_file_serialization/exec/product_manager_binary_file/data/dataproducts.txt";

    public static List<Product> readProduct() {
        List<Product> productList = new ArrayList<>();
        Product product;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(FILEBATH);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (fileInputStream.available() > 0) {
                product = (Product) objectInputStream.readObject();
                productList.add(product);
            }
        } catch (EOFException ignored) {
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                objectInputStream.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return productList;
    }

    public static boolean checkData() {
        boolean isCanReadData = false;
        try {
            File file = new File(FILEBATH);
            isCanReadData = file.canRead();
        } catch (Exception ignored) {
        }
        return isCanReadData;
    }
}