package ss12_java_collection_framework.exec.use_arrayList_linkedList.reprositories;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.models.Product;

import java.util.List;

public interface IProductRepository {
    void addProduct(Product product);

    void editProduct(Integer id, Product product);

    boolean checkID(Integer id);

    void removeProduct(Integer id);

    List<Product> getAll();

    Product searchProductsByName(String name);

    void sortAscendingProduct();

    void sortDescendingProduct();
}
