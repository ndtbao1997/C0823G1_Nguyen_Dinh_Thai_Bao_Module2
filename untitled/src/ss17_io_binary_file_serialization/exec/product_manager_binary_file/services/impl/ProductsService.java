package ss17_io_binary_file_serialization.exec.product_manager_binary_file.services.impl;

import ss17_io_binary_file_serialization.exec.product_manager_binary_file.models.Product;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.repositories.IProductsRepository;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.repositories.impl.ProductsRepository;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.services.IProductsService;

import java.util.List;

public class ProductsService implements IProductsService {
    private final IProductsRepository iProductsRepository = new ProductsRepository();

    @Override
    public boolean checkId(Integer id) {
        return iProductsRepository.checkId(id);
    }

    @Override
    public void addProduct(Integer id, Product product) {
        iProductsRepository.addProduct(id, product);
    }

    @Override
    public List<Product> getAll() {
        return iProductsRepository.getAll();
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return iProductsRepository.searchProductByName(name);
    }
}
