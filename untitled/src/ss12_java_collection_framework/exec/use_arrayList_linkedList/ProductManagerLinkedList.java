package ss12_java_collection_framework.exec.use_arrayList_linkedList;

import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.PriceComparator;
import ss12_java_collection_framework.exec.use_arrayList_linkedList.model.Product;

import java.util.*;

public class ProductManagerLinkedList {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> listProduct = new LinkedList<>();
    static {
        listProduct.add(new Product(1, "Dao", 30000));
        listProduct.add(new Product(2, "Kéo", 25000));
        listProduct.add(new Product(3, "Chảo", 45000));
    }
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
        listProduct.add(new Product(id, name, price));
    }

    private static int inputID() {
        int id;
        do {
            System.out.println("Hãy nhập id sản phẩm vào");
            id = Integer.parseInt(scanner.nextLine());
            if (checkID(id)) {
                System.out.println("Id bạn nhập đã tồn tại");
            }
        } while (checkID(id));
        return id;
    }

    private static boolean checkID(int id) {
        for (Product product : listProduct) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public static void editProduct() {
        System.out.println("Hãy nhập id bạn muốn sửa");
        int id = Integer.parseInt(scanner.nextLine());
        int newId;
        String newName;
        double newPrice;
        for (Product product : listProduct) {
            if (product.getId() == id) {
                newId = inputID();
                System.out.println("Hãy nhập tên mới cho sản phẩm");
                newName = scanner.nextLine();
                System.out.println("Hãy nhập giá mới cho sản phẩm");
                newPrice = Double.parseDouble(scanner.nextLine());
                product.setId(newId);
                product.setName(newName);
                product.setPrice(newPrice);
                return;
            }
        }
        System.out.println("Id bạn nhập vào không tồn tại");
    }
    public static void displayProduct() {
        for (Product product : listProduct) {
            System.out.println(product);
        }
    }
    public static void removeProduct() {
        System.out.println("Hãy nhập Id bạn muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : listProduct) {
            if (product.getId() == id) {
                confirmRemove(product);
                return;
            }
        }
        System.out.println("Id bạn nhập không tồn tại");
    }

    private static void confirmRemove(Product product) {
        String choice;
        System.out.println("Hãy chắc chắn rằng bạn muốn xóa?\n" +
                "Nhập Yes hoặc No.");
        do {
            choice = scanner.nextLine();
            switch (choice){
                case "Yes":
                    listProduct.remove(product);
                    System.out.println("Bạn đã xóa thành công");
                    return;
                case "No":
                    System.out.println("Bạn đã hủy xóa");
                    return;
                default:
                    System.out.println("Chỉ được nhập Yes hoặc No");
            }
        }while (true);
    }
    public static void searchProductsByName() {
        System.out.println("Hãy nhập tên sản phẩm bạn muốn tìm");
        String name = scanner.nextLine();
        for (Product product : listProduct) {
            if (Objects.equals(product.getName(), name)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Tên sản phẩm không tồn tại");
    }
    public static void sortProduct() {
        int choice;
        do {
            System.out.println("Nhập 1 nếu tăng dần.\n" +
                    "Nhập 2 nếu giảm dần");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Collections.sort(listProduct);
                    displayProduct();
                    return;
                case 2:
                    Collections.sort(listProduct, new PriceComparator());
                    displayProduct();
                    return;
                default:
                    System.out.println("Chỉ được nhập 1 hoặc 2.");
            }
        } while (true);
    }
}
