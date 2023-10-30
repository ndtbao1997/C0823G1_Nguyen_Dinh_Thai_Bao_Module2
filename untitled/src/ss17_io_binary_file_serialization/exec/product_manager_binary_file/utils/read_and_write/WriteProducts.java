package ss17_io_binary_file_serialization.exec.product_manager_binary_file.utils.read_and_write;

import ss17_io_binary_file_serialization.exec.product_manager_binary_file.models.Product;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteProducts {
    private static final String FILEBATH =
            "src/ss17_io_binary_file_serialization/exec/product_manager_binary_file/data/dataproducts.txt";

    public static void writeToFile(List<Product> products) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILEBATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (Product product : products) {
                objectOutputStream.writeObject(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
