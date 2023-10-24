package ss12_java_collection_framework.exec.use_arrayList_linkedList.controller;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.service.IProductService;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.service.ProductService;

public class ProductController {
    private IProductService iProductService = new ProductService();

    public void addProduct(int id, String name, double price) {
        iProductService.addProduct(id, name, price);
    }

    public boolean checkID(int id) {
        return iProductService.checkID(id);
    }

    public void editProduct(int id, int newId, String newName, double newPrice) {
        iProductService.editProduct(id, newId, newName, newPrice);
    }

    public void removeProduct(int id) {
        iProductService.removeProduct(id);
    }

    public void displayProduct() {
        iProductService.displayProduct();
    }

    public void searchProductsByName(String name) {
        iProductService.searchProductsByName(name);
    }

    public void sortAscendingProduct() {
        iProductService.sortAscendingProduct();
    }

    public void sortDescendingProduct() {
        iProductService.sortDescendingProduct();
    }
}
