package ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.Product;

import java.util.List;

public interface IProductRepository {
    void addProduct(Product product);

    void editProduct(int id, Product product);

    boolean checkID(int id);

    void removeProduct(int id);

    List<Product> getAll();

    void searchProductsByName(String name);

    void sortAscendingProduct();

    void sortDescendingProduct();
}
