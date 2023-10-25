package ss12_java_collection_framework.exec.use_arrayList_linkedList.service;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);

    boolean checkID(int id);

    void editProduct(int id, Product product);

    void removeProduct(int id);

    List<Product> getAll();

    void searchProductsByName(String name);

    void sortAscendingProduct();

    void sortDescendingProduct();
}
