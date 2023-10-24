package ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository;

public interface IProductRepository {
    void addProduct(int id, String name, double price);

    void editProduct(int id, int newId, String newName, double newPrice);

    boolean checkID(int id);

    void removeProduct(int id);

    void displayProduct();

    void searchProductsByName(String name);

    void sortAscendingProduct();

    void sortDescendingProduct();
}
