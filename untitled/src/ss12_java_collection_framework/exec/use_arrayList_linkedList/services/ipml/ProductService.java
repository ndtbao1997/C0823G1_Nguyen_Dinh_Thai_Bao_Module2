package ss12_java_collection_framework.exec.use_arrayList_linkedList.services.ipml;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.models.Product;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.reprositories.IProductRepository;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.reprositories.ipml.ProductRepository;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.services.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private final IProductRepository iProductRepository = new ProductRepository();

    @Override
    public void addProduct(Product product) {
        iProductRepository.addProduct(product);
    }

    @Override
    public boolean checkID(Integer id) {
        return iProductRepository.checkID(id);
    }

    @Override
    public void editProduct(Integer id, Product product) {
        iProductRepository.editProduct(id, product);
    }

    @Override
    public void removeProduct(Integer id) {
        iProductRepository.removeProduct(id);
    }

    @Override
    public List<Product> getAll() {
        return iProductRepository.getAll();
    }

    @Override
    public Product searchProductsByName(String name) {
        return iProductRepository.searchProductsByName(name);
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
