package ss17_io_binary_file_serialization.exec.product_manager_binary_file.controllers;

import ss17_io_binary_file_serialization.exec.product_manager_binary_file.models.Product;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.services.IProductsService;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.services.impl.ProductsService;

import java.util.List;

public class ProductsController {
    private final IProductsService iProductsService = new ProductsService();

    public boolean checkId(Integer id) {
        return iProductsService.checkId(id);
    }

    public void addProduct(Integer id, Product product) {
        iProductsService.addProduct(id, product);
    }

    public List<Product> getAll() {
        return iProductsService.getAll();
    }

    public List<Product> searchProductByName(String name) {
        return iProductsService.searchProductByName(name);
    }
}
