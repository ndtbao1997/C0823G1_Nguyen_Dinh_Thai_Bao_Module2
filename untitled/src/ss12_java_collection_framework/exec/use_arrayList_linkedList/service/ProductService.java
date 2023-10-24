package ss12_java_collection_framework.exec.use_arrayList_linkedList.service;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository.ProductRepository;

public class ProductService implements IProductService {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public void addProduct(int id, String name, double price) {
        productRepository.addProduct(id, name, price);
    }

    @Override
    public boolean checkID(int id) {
        return productRepository.checkID(id);
    }

    @Override
    public void editProduct(int id, int newId, String newName, double newPrice) {
        productRepository.editProduct(id, newId, newName, newPrice);
    }

    @Override
    public void removeProduct(int id) {
        productRepository.removeProduct(id);
    }

    @Override
    public void displayProduct() {
        productRepository.displayProduct();
    }

    @Override
    public void searchProductsByName(String name) {
        productRepository.searchProductsByName(name);
    }

    @Override
    public void sortAscendingProduct() {
        productRepository.sortAscendingProduct();
    }

    @Override
    public void sortDescendingProduct() {
        productRepository.sortDescendingProduct();
    }
}
