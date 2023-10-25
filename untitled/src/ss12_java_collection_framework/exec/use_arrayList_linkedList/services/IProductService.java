package ss12_java_collection_framework.exec.use_arrayList_linkedList.services;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.models.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);

    boolean checkID(Integer id);

    void editProduct(Integer id, Product product);

    void removeProduct(Integer id);

    List<Product> getAll();

    Product searchProductsByName(String name);

    void sortAscendingProduct();

    void sortDescendingProduct();
}
