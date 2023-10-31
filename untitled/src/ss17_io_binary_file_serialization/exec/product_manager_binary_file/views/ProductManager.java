package ss17_io_binary_file_serialization.exec.product_manager_binary_file.views;

import ss17_io_binary_file_serialization.exec.product_manager_binary_file.controllers.ProductsController;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.models.Product;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.utils.validate.check_information.InformationExample;
import ss17_io_binary_file_serialization.exec.product_manager_binary_file.utils.validate.exception.ProductInformationIsIncorrect;

import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static final ProductsController producstController = new ProductsController();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            try {
                System.out.println("1.Thêm sản phẩm\n" +
                        "2.Hiển thị danh sách sản phẩm\n" +
                        "3.Tìm kiếm sản phẩm theo tên \n" +
                        "4.Thoát chương trình");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        displayProducts();
                        break;
                    case 3:
                        searchProductByName();
                        break;
                    case 4:
                        System.out.println("Chào tạm biệt");
                        System.exit(0);
                    default:
                        System.out.println("Bạn đã nhập sai. Xin vui lòng nhập lại");
                }
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        } while (true);
    }

    public static void searchProductByName() {
        System.out.println("Nhập tên sản phẩm bạn muốn tìm");
        String name = scanner.nextLine();
        List<Product> searchProducts = producstController.searchProductByName(name);
        if (!searchProducts.isEmpty()) {
            for (Product product : searchProducts) {
                System.out.println(product);
            }
        } else {
            System.out.println("Không có sản phẩm nào được tìm thấy");
        }
    }

    public static void displayProducts() {
        List<Product> products = producstController.getAll();
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Danh sách hiện tại không chứa sản phẩm");
        }

    }

    public static void addProduct() {
        try {
            Integer id = inputId();
            Product product = inputInforProduct();
            producstController.addProduct(id, product);
            System.out.println("Bạn đã thêm thành công");
        } catch (ProductInformationIsIncorrect e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Mời bạn thao tác lại từ đầu");
        }
    }

    private static Product inputInforProduct() throws Exception {
        System.out.println("Nhập tên sản phẩm");
        String name = inputName();
        System.out.println("Nhập giá sản phẩm");
        Long price = Long.parseLong(scanner.nextLine());
        if (price <= 0) {
            throw new ProductInformationIsIncorrect("Thông tin sản phẩm không đúng");
        }
        System.out.println("Nhập hãng sản xuất");
        String manufacturer = inputManufacturer();
        System.out.println("Mô tả sản phẩm");
        String describe = inputDescripe();
        return new Product(name, price, manufacturer, describe);
    }

    private static String inputDescripe() {
        String describe;
        do {
            describe = scanner.nextLine();
            if (InformationExample.validateDescripe(describe)) {
                System.out.println("Mô tả không đúng xin mời bạn nhập lại");
            }
        } while (InformationExample.validateDescripe(describe));
        return describe;
    }

    private static String inputManufacturer() {
        String manufacturer;
        do {
            manufacturer = scanner.nextLine();
            if (InformationExample.validateManufacturer(manufacturer)) {
                System.out.println("Hãng không hợp lệ. Xin mời bạn nhập lại.");
            }
        } while (InformationExample.validateManufacturer(manufacturer));
        return manufacturer;
    }

    private static String inputName() {
        String name;
        do {
            name = scanner.nextLine();
            if (InformationExample.validateName(name)) {
                System.out.println("Tên không hợp lệ. Xin mời bạn nhập lại.");
            }
        } while (InformationExample.validateName(name));
        return name;
    }

    private static Integer inputId() throws Exception {
        Integer id;
        do {
            System.out.println("Nhập id sản phẩm:");
            id = Integer.parseInt(scanner.nextLine());
            if (producstController.checkId(id)) {
                System.out.println("Id đã tồn tại. Xin mời bạn nhập lại.");
            }
        } while (producstController.checkId(id));
        if (id <= 0) {
            throw new ProductInformationIsIncorrect("Thông tin sản phẩm không đúng");
        }
        return id;
    }
}
