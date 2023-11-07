package case_study_2.furama_resort.view;

import java.util.*;

public class FuramaResort {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FuramaResort.displayMainMenu();
    }

    public static void displayMainMenu() {
        int choice;
        try {
            do {
                System.out.println("1.Quản lý nhân sự \n" +
                        "2.Quản lý khách hàng\n" +
                        "3.Quản lý cơ sở dịch vụ\n" +
                        "4.Quản lý đặt chỗ\n" +
                        "5.Quản lý khuyến mãi\n" +
                        "6.Thoát chương trình");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        FuramaPersonManager.displayEmployeeManagement();
                        break;
                    case 2:
                        FuramaPersonManager.displayCustomerManagement();
                        break;
                    case 3:
                        FuramaFacilityManager.displayFacilityManagement();
                        break;
                    case 4:
                        BookingAndContractManager.displayBookingManagement();
                        break;
                    case 5:
                        PromotionManager.displayPromotionManagement();
                        break;
                    case 6:
                        System.out.println("Chào tạm biệt");
                        System.exit(6);
                    default:
                        System.out.println("Xin vui lòng nhập lại\n");
                }
            } while (true);
        } catch (Exception e) {
            System.err.println("Thao tác không hợp lệ!!!\n");
        }
    }
}
