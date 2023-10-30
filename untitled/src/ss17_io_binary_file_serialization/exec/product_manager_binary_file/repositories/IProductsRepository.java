package ss17_io_binary_file_serialization.exec.product_manager_binary_file.repositories;

import ss17_io_binary_file_serialization.exec.product_manager_binary_file.models.Product;

import java.util.List;

public interface IProductsRepository {
    boolean checkId(Integer id);

    void addProduct(Integer id, Product product);

    List<Product> getAll();

    List<Product> searchProductByName(String name);
}
