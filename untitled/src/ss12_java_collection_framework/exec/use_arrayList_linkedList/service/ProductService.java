package ss12_java_collection_framework.exec.use_arrayList_linkedList.service;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository.IProductRepository;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository.ProductRepository;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public void addProduct(int id, String name, double price) {
        iProductRepository.addProduct(id, name, price);
    }

    @Override
    public boolean checkID(int id) {
        return iProductRepository.checkID(id);
    }

    @Override
    public void editProduct(int id, int newId, String newName, double newPrice) {
        iProductRepository.editProduct(id, newId, newName, newPrice);
    }

    @Override
    public void removeProduct(int id) {
        iProductRepository.removeProduct(id);
    }

    @Override
    public void displayProduct() {
        iProductRepository.displayProduct();
    }

    @Override
    public void searchProductsByName(String name) {
        iProductRepository.searchProductsByName(name);
    }

    @Override
    public void sortAscendingProduct() {
        iProductRepository.sortAscendingProduct();
    }

    @Override
    public void sortDescendingProduct() {
        iProductRepository.sortDescendingProduct();
    }
}
