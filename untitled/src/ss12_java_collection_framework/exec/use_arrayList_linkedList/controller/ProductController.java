package ss12_java_collection_framework.exec.use_arrayList_linkedList.controller;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.Product;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.service.IProductService;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.service.ProductService;

import java.util.List;

public class ProductController {
    private final IProductService iProductService = new ProductService();

    public void addProduct(Product product) {
        iProductService.addProduct(product);
    }

    public boolean checkID(int id) {
        return iProductService.checkID(id);
    }

    public void editProduct(int id, Product product) {
        iProductService.editProduct(id, product);
    }

    public void removeProduct(int id) {
        iProductService.removeProduct(id);
    }

    public List<Product> getAll() {
        return iProductService.getAll();

    }

    public void searchProductsByName(String name) {
        iProductService.searchProductsByName(name);
    }

    public void sortAscendingProduct() {
        iProductService.sortAscendingProduct();
    }

    public void sortDescendingProduct() {
        iProductService.sortDescendingProduct();
    }
}
