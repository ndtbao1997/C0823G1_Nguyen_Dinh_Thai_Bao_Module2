package ss12_java_collection_framework.exec.use_arrayList_linkedList.reprositories.ipml;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.reprositories.IProductRepository;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.utils.comparator.PriceComparator;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProductRepository implements IProductRepository {
    private static final List<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product(1, "Dao", 30000L));
        listProduct.add(new Product(2, "Kéo", 25000L));
        listProduct.add(new Product(3, "Chảo", 45000L));
    }

    @Override
    public void addProduct(Product product) {
        listProduct.add(product);
    }

    @Override
    public boolean checkID(Integer id) {
        for (Product product : listProduct) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void editProduct(Integer id, Product product) {
        for (Product p : listProduct) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return;
            }
        }
    }

    @Override
    public void removeProduct(Integer id) {
        for (Product product : listProduct) {
            if (product.getId() == id) {
                listProduct.remove(product);
                return;
            }
        }
    }

    @Override
    public List<Product> getAll() {
        return listProduct;
    }

    @Override
    public Product searchProductsByName(String name) {
        for (Product product : listProduct) {
            if (Objects.equals(product.getName(), name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void sortAscendingProduct() {
        Collections.sort(listProduct);
    }

    @Override
    public void sortDescendingProduct() {
        Collections.sort(listProduct, new PriceComparator());
    }
}
