package ss12_java_collection_framework.exec.use_arrayList_linkedList.service;

public interface IProductService {
    void addProduct(int id, String name, double price);

    boolean checkID(int id);

    void editProduct(int id, int newId, String newName, double newPrice);

    void removeProduct(int id);

    void displayProduct();

    void searchProductsByName(String name);

    void sortAscendingProduct();

    void sortDescendingProduct();
}
