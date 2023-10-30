package ss17_io_binary_file_serialization.exec.product_manager_binary_file.repositories.impl;

import ss17_io_binary_file_serialization.exec.product_manager_binary_file.models.Product;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.repositories.IProductsRepository;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.utils.read_and_write.ReadProducts;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.utils.read_and_write.WriteProducts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductsRepository implements IProductsRepository {
    public List<Product> getListProducts() {
        List<Product> listProducts = new ArrayList<>();
        if (ReadProducts.checkData()) {
            return ReadProducts.readProduct();
        } else {
            return listProducts;
        }
    }

    @Override
    public boolean checkId(Integer id) {
        List<Product> listProducts = getListProducts();
        for (Product product : listProducts) {
            if (Objects.equals(product.getId(), id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProduct(Integer id, Product product) {
        List<Product> listProducts = getListProducts();
        listProducts.add(new Product(id, product.getName(), product.getPrice(), product.getManufacturer(), product.getDescribe()));
        WriteProducts.writeToFile(listProducts);
    }

    @Override
    public List<Product> getAll() {
        return getListProducts();
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> listProducts = getListProducts();
        List<Product> searchProducts = new ArrayList<>();
        for (Product product : listProducts) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                searchProducts.add(product);
            }
        }
        return searchProducts;
    }
}
