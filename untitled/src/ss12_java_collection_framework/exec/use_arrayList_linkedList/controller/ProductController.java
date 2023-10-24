package ss12_java_collection_framework.exec.use_arrayList_linkedList.controller;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.service.ProductService;

public class ProductController {
    private static ProductService productService = new ProductService();
    public void addProduct(int id, String name, double price) {
        productService.addProduct(id, name, price);
    }
    public boolean checkID(int id){
        return productService.checkID(id);
    }
    public void editProduct(int id, int newId, String newName, double newPrice) {
        productService.editProduct(id,newId,newName,newPrice);
    }
    public void removeProduct(int id) {
        productService.removeProduct(id);
    }
    public void displayProduct() {
        productService.displayProduct();
    }
    public void searchProductsByName(String name) {
        productService.searchProductsByName(name);
    }
    public void sortAscendingProduct(){
        productService.sortAscendingProduct();
    }
    public void sortDescendingProduct(){
        productService.sortDescendingProduct();
    }
}
