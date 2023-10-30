package ss17_io_binary_file_serialization.exec.product_manager_binary_file.services;

import ss17_io_binary_file_serialization.exec.product_manager_binary_file.models.Product;

import java.util.List;

public interface IProductsService {
    boolean checkId(Integer id);

    void addProduct(Integer id, Product product);

    List<Product> getAll();

    List<Product> searchProductByName(String name);
}
