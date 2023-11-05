package case_study_2.furama_resort.view;

import case_study_2.furama_resort.controller.PromotionController;
import case_study_2.furama_resort.model.person.Customer;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class PromotionManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PromotionController promotionController = new PromotionController();

    public static void displayPromotionManagement() {
        int choice;
        try {
            do {
                System.out.println("1.Display list customers use service\n" +
                        "2.Display list customers get voucher\n" +
                        "3.Return main menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayListCustomerUseService();
                        break;
                    case 2:
                        displayListCustomersGetVoucher();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Xin vui lòng nhập lại\n");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Thao tác không hợp lệ!!!\n");
        }
    }

    public static void displayListCustomersGetVoucher() {
        int voucher10;
        int voucher20;
        int voucher50;
        Stack<Customer> customerStack = promotionController.getStackCustomer();
        if (customerStack.isEmpty()) {
            System.out.println("Hiện tại không có khách hàng nào có thể nhận Voucher!");
        } else {
            try {
                do {
                    System.out.println("Hãy nhập số lượng voucher 10% (lớn hơn hoặc bằng 0)");
                    voucher10 = Integer.parseInt(scanner.nextLine());
                } while (voucher10 < 0);
                do {
                    System.out.println("Hãy nhập số lượng voucher 20% (lớn hơn hoặc bằng 0)");
                    voucher20 = Integer.parseInt(scanner.nextLine());
                } while (voucher20 < 0 && !customerStack.isEmpty());
                do {
                    System.out.println("Hãy nhập số lượng voucher 50% (lớn hơn hoặc bằng 0)");
                    voucher50 = Integer.parseInt(scanner.nextLine());
                } while (voucher50 < 0);
                if (voucher10 > 0 && (!customerStack.isEmpty())) {
                    System.out.println("Khách hàng nhận voucher 10 là");
                    for (int i = 0; i < voucher10; i++) {
                        System.out.println(customerStack.pop());
                    }
                }
                if (voucher20 > 0 && (!customerStack.isEmpty())) {
                    System.out.println("Khách hàng nhận voucher 20 là");
                    for (int j = 0; j < voucher20; j++) {
                        System.out.println(customerStack.pop());
                    }
                }
                if (voucher50 > 0 && (!customerStack.isEmpty())) {
                    System.out.println("Khách hàng nhận voucher 50 là");
                    for (int k = 0; k < voucher50; k++) {
                        System.out.println(customerStack.pop());
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public static void displayListCustomerUseService() {
        Set<Customer> customerSet = promotionController.getCustomerPromotion();
        if (customerSet.isEmpty()) {
            System.out.println("Hiện tại không có khách hàng nào sử dụng dịch vụ theo năm cả!");
        } else {
            for (Customer customer : customerSet) {
                System.out.println(customer);
            }
        }
    }
}
