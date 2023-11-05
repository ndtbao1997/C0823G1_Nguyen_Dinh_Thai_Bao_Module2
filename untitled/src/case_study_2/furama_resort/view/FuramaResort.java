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
                System.out.println("1.Employee Management \n" +
                        "2.Customer Management\n" +
                        "3.Facility Management\n" +
                        "4.Booking Management\n" +
                        "5.Promotion Management\n" +
                        "6.Exit");
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
