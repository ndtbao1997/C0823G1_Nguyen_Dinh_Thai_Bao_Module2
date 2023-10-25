package ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.utils.PriceComparator;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProductRepository implements IProductRepository {
    private static final List<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product(1, "Dao", 30000));
        listProduct.add(new Product(2, "Kéo", 25000));
        listProduct.add(new Product(3, "Chảo", 45000));
    }

    @Override
    public void addProduct(Product product) {
        listProduct.add(product);
    }

    @Override
    public boolean checkID(int id) {
        for (Product product : listProduct) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void editProduct(int id, Product product) {
        for (Product p : listProduct) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return;
            }
        }
    }

    @Override
    public void removeProduct(int id) {
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
    public void searchProductsByName(String name) {
        for (Product product : listProduct) {
            if (Objects.equals(product.getName(), name)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Tên sản phẩm không tồn tại");
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
