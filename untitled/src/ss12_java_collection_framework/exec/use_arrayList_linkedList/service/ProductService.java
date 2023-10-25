package ss12_java_collection_framework.exec.use_arrayList_linkedList.service;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.Product;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository.IProductRepository;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository iProductRepository = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        iProductRepository.addProduct(product);
    }

    @Override
    public boolean checkID(int id) {
        return iProductRepository.checkID(id);
    }

    @Override
    public void editProduct(int id, Product product) {
        iProductRepository.editProduct(id, product);
    }

    @Override
    public void removeProduct(int id) {
        iProductRepository.removeProduct(id);
    }

    @Override
    public List<Product> getAll() {
        return iProductRepository.getAll();
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
