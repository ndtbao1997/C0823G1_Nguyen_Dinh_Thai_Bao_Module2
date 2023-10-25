package ss12_java_collection_framework.exec.use_arrayList_linkedList.view;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.controller.ProductController;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.Product;

import java.util.*;

public class ProductManagerArrayList {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductController productController = new ProductController();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1.Thêm sản phẩm\n" +
                    "2.Sửa thông tin sản phẩm theo id\n" +
                    "3.Xoá sản phẩm theo id\n" +
                    "4.Hiển thị danh sách sản phẩm\n" +
                    "5.Tìm kiếm sản phẩm theo tên\n" +
                    "6.Sắp xếp sản phẩm tăng dần, giảm dần theo giá\n" +
                    "7.Thoát chương trình");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    displayProduct();
                    break;
                case 5:
                    searchProductsByName();
                    break;
                case 6:
                    sortProduct();
                    break;
                case 7:
                    System.out.println("Hẹn gặp lại");
                    System.exit(7);
                default:
                    System.out.println("Bạn đã nhập sai. Xin nhập lại.");
            }
        } while (true);
    }

    public static void addProduct() {
        int id = inputID();
        System.out.println("Hãy nhập tên sản phẩm vào.");
        String name = scanner.nextLine();
        System.out.println("Hãy nhập giá sản phẩm vào");
        double price = Double.parseDouble(scanner.nextLine());
        productController.addProduct(new Product(id, name, price));
    }

    private static int inputID() {
        int id;
        do {
            System.out.println("Hãy nhập id sản phẩm vào");
            id = Integer.parseInt(scanner.nextLine());
            if (productController.checkID(id)) {
                System.out.println("Id bạn nhập đã tồn tại");
            }
        } while (productController.checkID(id));
        return id;
    }

    public static void editProduct() {
        System.out.println("Hãy nhập id bạn muốn sửa");
        int id = Integer.parseInt(scanner.nextLine());
        String newName;
        double newPrice;
        if (productController.checkID(id)) {
            System.out.println("Hãy nhập tên mới cho sản phẩm");
            newName = scanner.nextLine();
            System.out.println("Hãy nhập giá mới cho sản phẩm");
            newPrice = Double.parseDouble(scanner.nextLine());
            productController.editProduct(id, new Product(id, newName, newPrice));
        }
        System.out.println("Id bạn nhập vào không tồn tại");
    }

    public static void removeProduct() {
        System.out.println("Hãy nhập Id bạn muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        if (productController.checkID(id)) {
            confirmRemove(id);
        }
        System.out.println("Id bạn nhập không tồn tại");
    }

    private static void confirmRemove(int id) {
        String choice;
        System.out.println("Hãy chắc chắn rằng bạn muốn xóa?\n" +
                "Nhập Yes hoặc No.");
        do {
            choice = scanner.nextLine();
            switch (choice) {
                case "Yes":
                    productController.removeProduct(id);
                    System.out.println("Bạn đã xóa thành công");
                    return;
                case "No":
                    System.out.println("Bạn đã hủy xóa");
                    return;
                default:
                    System.out.println("Chỉ được nhập Yes hoặc No");
            }
        } while (true);
    }

    public static void displayProduct() {
        List<Product> productList = productController.getAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void searchProductsByName() {
        System.out.println("Hãy nhập tên sản phẩm bạn muốn tìm");
        String name = scanner.nextLine();
        productController.searchProductsByName(name);
    }

    public static void sortProduct() {
        int choice;
        do {
            System.out.println("Nhập 1 nếu tăng dần.\n" +
                    "Nhập 2 nếu giảm dần");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productController.sortAscendingProduct();
                    displayProduct();
                    return;
                case 2:
                    productController.sortDescendingProduct();
                    displayProduct();
                    return;
                default:
                    System.out.println("Chỉ được nhập 1 hoặc 2.");
            }
        } while (true);
    }
}
