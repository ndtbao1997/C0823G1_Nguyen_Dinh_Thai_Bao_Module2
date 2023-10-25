package ss12_java_collection_framework.exec.use_arrayList_linkedList.controllers;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.models.Product;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.services.IProductService;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.services.ipml.ProductService;

import java.util.List;

public class ProductController {
    private final IProductService iProductService = new ProductService();

    public void addProduct(Product product) {
        iProductService.addProduct(product);
    }

    public boolean checkID(Integer id) {
        return iProductService.checkID(id);
    }

    public void editProduct(Integer id, Product product) {
        iProductService.editProduct(id, product);
    }

    public void removeProduct(Integer id) {
        iProductService.removeProduct(id);
    }

    public List<Product> getAll() {
        return iProductService.getAll();

    }

    public Product searchProductsByName(String name) {
        return iProductService.searchProductsByName(name);
    }

    public void sortAscendingProduct() {
        iProductService.sortAscendingProduct();
    }

    public void sortDescendingProduct() {
        iProductService.sortDescendingProduct();
    }
}
