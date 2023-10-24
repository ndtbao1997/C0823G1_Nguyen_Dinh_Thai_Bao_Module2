package ss12_java_collection_framework.exec.use_arrayList_linkedList.reprository;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.PriceComparator;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProductRepository implements IProductRepository{
    private static List<Product> listProduct = new ArrayList<>();

    static {
        listProduct.add(new Product(1, "Dao", 30000));
        listProduct.add(new Product(2, "Kéo", 25000));
        listProduct.add(new Product(3, "Chảo", 45000));
    }

    @Override
    public void addProduct(int id, String name, double price) {
        listProduct.add(new Product(id,name,price));
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
    public void editProduct(int id, int newId, String newName, double newPrice) {
        for (Product product: listProduct){
            if (product.getId() == id){
                product.setId(newId);
                product.setName(newName);
                product.setPrice(newPrice);
                return;
            }
        }
    }

    @Override
    public void removeProduct(int id) {
        for (Product product:listProduct){
            if (product.getId() == id){
                listProduct.remove(product);
                return;
            }
        }
    }

    @Override
    public void displayProduct() {
        for (Product product : listProduct) {
            System.out.println(product);
        }
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
        displayProduct();
    }

    @Override
    public void sortDescendingProduct() {
        Collections.sort(listProduct, new PriceComparator());
        displayProduct();
    }
}
