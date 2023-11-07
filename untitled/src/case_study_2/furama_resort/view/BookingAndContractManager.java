package case_study_2.furama_resort.view;

import case_study_2.furama_resort.controller.*;
import case_study_2.furama_resort.model.booking_contract.Booking;
import case_study_2.furama_resort.model.booking_contract.Contract;
import case_study_2.furama_resort.untils.validate.BookingInforExample;
import case_study_2.furama_resort.untils.validate.FacilityInforExample;
import case_study_2.furama_resort.untils.validate.PersonInforExample;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BookingAndContractManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerController customerController = new CustomerController();
    private static final FacilityController facilityController = new FacilityController();
    private static final BookingController bookingController = new BookingController();
    private static final ContactController contactController = new ContactController();

    public static void displayBookingManagement() {
        int choice;
        try {
            do {
                System.out.println("1.Thêm lịch đặt chỗ mới\n" +
                        "2.Hiển thị lịch đặt chỗ\n" +
                        "3.Tạo hợp đồng\n" +
                        "4.Hiển thị danh sách hợp đồng\n" +
                        "5.Sửa hợp đồng\n" +
                        "6.Quay lại Menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addNewBooking();
                        break;
                    case 2:
                        distplayListBooking();
                        break;
                    case 3:
                        createNewcontracts();
                        break;
                    case 4:
                        displayListContracts();
                        break;
                    case 5:
                        editContracts();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Xin vui lòng nhập lại\n");
                }
            } while (true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void editContracts() {
        String someContract;
        Long advanceDepositAmount;
        Long totalPaymentAmount;
        String bookingCode;
        System.out.println("Nhập mã số hợp đồng bạn cần sửa");
        do {
            try {
                someContract = scanner.nextLine();
                if (BookingInforExample.validateSomeContracts(someContract) && contactController.checkObjectCode(someContract)) {
                    bookingCode = contactController.getBookingCode(someContract);
                    advanceDepositAmount = inputAdvanceDepositAmount(bookingCode);
                    totalPaymentAmount = inputTotalPaymentAmount(bookingCode);
                    contactController.editObject(new Contract(someContract, bookingCode, advanceDepositAmount, totalPaymentAmount));
                    System.out.println("Bạn đã sửa thành công");
                    return;
                } else {
                    System.out.println("Không hợp lệ hoặc không tồn tại!\n" +
                            "Xin nhập lại");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void displayListContracts() {
        List<Contract> contractList = contactController.getAll();
        if (contractList.isEmpty()) {
            System.out.println("Hiện tại không có hợp đồng nào cả");
        } else {
            for (Contract contract : contractList) {
                System.out.println("someContracts='" + contract.getSomeContracts() + '\'' +
                        ", bookingCode='" + contract.getBookingCode() + '\'' +
                        ", advanceDepositAmount='" + contract.getAdvanceDepositAmount() + '\'' +
                        ", totalPaymentAmount='" + contract.getTotalPaymentAmount() + '\'');
            }
        }
    }

    public static void createNewcontracts() {
        Queue<Booking> bookingQueue = bookingController.getBookingVillaAndHouse();
        String someContracts;
        String bookingCode;
        Long advanceDepositAmount;
        Long totalPaymentAmount;
        while (!bookingQueue.isEmpty()) {
            try {
                bookingCode = bookingQueue.peek().getBookingCode();
                if (contactController.checkObjectCode(bookingCode)) {
                    bookingQueue.poll();
                } else {
                    someContracts = inputSomeContracts(bookingCode);
                    advanceDepositAmount = inputAdvanceDepositAmount(bookingCode);
                    totalPaymentAmount = inputTotalPaymentAmount(bookingCode);
                    contactController.addObject(new Contract(someContracts, bookingCode, advanceDepositAmount, totalPaymentAmount));
                    bookingQueue.poll();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Tất cả hợp đồng đã hoàn tất");
    }

    public static Long inputTotalPaymentAmount(String bookingCode) {
        Long advanceDepositAmount;
        System.out.println("Nhập tổng số tiền thanh toán (phải lớn hơn 0) của: " + bookingCode);
        do {
            advanceDepositAmount = Long.parseLong(scanner.nextLine());
            if (advanceDepositAmount <= 0) {
                System.out.println("Xin nhập lại!");
            }
        } while (advanceDepositAmount <= 0);
        return advanceDepositAmount;
    }

    public static Long inputAdvanceDepositAmount(String bookingCode) {
        Long advanceDepositAmount;
        System.out.println("Nhập số tiền thanh toán trước (phải lớn hơn 0) của: " + bookingCode);
        do {
            advanceDepositAmount = Long.parseLong(scanner.nextLine());
            if (advanceDepositAmount <= 0) {
                System.out.println("Xin nhập lại");
            }
        } while (advanceDepositAmount <= 0);
        return advanceDepositAmount;
    }

    public static String inputSomeContracts(String bookingCode) {
        String someContracts;
        System.out.println("Hãy nhập số hợp đồng (phải có 5 chữ số) của: " + bookingCode);
        do {
            someContracts = scanner.nextLine();
            if (BookingInforExample.validateSomeContracts(someContracts) && (!contactController.checkObjectCode(someContracts))) {
                return someContracts;
            } else {
                System.out.println("Không hợp lệ hoặc đã tồn tại!\n" +
                        "Xin nhập lại!");
            }
        } while (true);
    }

    public static void distplayListBooking() {
        Set<Booking> bookingSet = bookingController.getAll();
        if (bookingSet.isEmpty()) {
            System.out.println("Hiện tại không có Booking nào cả!");
        } else {
            for (Booking booking : bookingSet) {
                System.out.println("bookingCode='" + booking.getBookingCode() + '\'' +
                        ", dateBooking='" + booking.getDateBooking() + '\'' +
                        ", rentalStartDate='" + booking.getRentalStartDate() + '\'' +
                        ", rentalEndDate='" + booking.getRentalEndDate() + '\'' +
                        ", customerCode='" + booking.getCustomerCode() + '\'' +
                        ", facilityCode='" + booking.getFacilityCode() + '\'');
            }
        }
    }

    public static void addNewBooking() {
        String bookingCode;
        String dateBooking;
        String rentalStartDate;
        String rentalEndDate;
        String customerCode;
        String facilityCode;
        try {
            System.out.println("Danh sách khách hàng:");
            FuramaPersonManager.displayListCustomer();
            customerCode = inputCustomerCodeBooking();
            System.out.println("Danh sách dịch vụ");
            FuramaFacilityManager.displayListFacility();
            facilityCode = inputFacilityCodeBooking();
            bookingCode = inputBookingCode();
            dateBooking = inputDateBooking();
            rentalStartDate = inputRentalStarDate(dateBooking, facilityCode);
            rentalEndDate = inputRentalEndDate(rentalStartDate);
            bookingController.addObject(new Booking(bookingCode, dateBooking, rentalStartDate, rentalEndDate, customerCode, facilityCode));
            System.out.println("Bạn đã thêm thành công!");
            facilityController.addObject(facilityCode);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static String inputRentalEndDate(String rentalStartDate) {
        String rentalEndDate;
        System.out.println("Nhập ngày kết thúc (phải là ngày bắt đầu hoặc các ngày tiếp theo):");
        do {
            rentalEndDate = scanner.nextLine();
            if (BookingInforExample.validateRentalDate(rentalEndDate, rentalStartDate)) {
                return rentalEndDate;
            } else {
                System.out.println("Không hợp lê!\n" +
                        "Xin nhập lại!");
            }
        } while (true);
    }

    public static String inputRentalStarDate(String dateBooking, String facilityCode) {
        String rentalStartDate;
        System.out.println("Nhập ngày bắt đầu (phải là ngày booking hoặc các ngày tiếp theo):");
        do {
            rentalStartDate = scanner.nextLine();
            if (BookingInforExample.validateRentalDate(rentalStartDate, dateBooking)) {
                return rentalStartDate;
            } else {
                System.out.println("Không hợp lê!\n" +
                        "Xin nhập lại!");
            }
        } while (true);
    }

    public static String inputDateBooking() {
        String dateBooking;
        System.out.println("Nhập ngày booking (phải là ngày hiện tại):");
        do {
            dateBooking = scanner.nextLine();
            if (BookingInforExample.validateDateBooking(dateBooking)) {
                return dateBooking;
            } else {
                System.out.println("Không hợp lê!\n" +
                        "Xin nhập lại!");
            }
        } while (true);
    }

    public static String inputBookingCode() {
        String bookingCode;
        System.out.println("Hãy nhập mã Booking (định dạng BK-XXXX):");
        do {
            bookingCode = scanner.nextLine();
            if (BookingInforExample.validateBookingCode(bookingCode) && (!bookingController.checkObjectCode(bookingCode))) {
                return bookingCode;
            } else {
                System.out.println("Không hợp lệ hoặc không tồn tại!\n" +
                        "Xin nhập lại");
            }
        } while (true);
    }

    public static String inputFacilityCodeBooking() {
        String facilityCode;
        System.out.println("Nhập mã dịch vụ (định dạng SVVL-XXXX hoặc SVHO-XXXX hoặc SVRO-XXXX)");
        do {
            facilityCode = scanner.nextLine();
            if (FacilityInforExample.validateServiceCode(facilityCode) &&
                    facilityController.checkObjectCode(facilityCode) &&
                    (!facilityController.checkRepair(facilityCode))) {
                return facilityCode;
            } else {
                System.out.println("Không hợp lệ hoặc không tồn tại hoặc đang bảo trì!\n" +
                        "Xin nhập lại");
            }
        } while (true);
    }

    public static String inputCustomerCodeBooking() {
        String customerCode;
        System.out.println("Hãy nhập mã khách hàng (định dạng KH-XXXX):");
        do {
            customerCode = scanner.nextLine();
            if (PersonInforExample.validateCustomerCode(customerCode) && customerController.checkObjectCode(customerCode)) {
                return customerCode;
            } else {
                System.out.println("Không hợp lệ hoặc không tồn tại!\n" +
                        "Xin nhập lại");
            }
        } while (true);
    }

}
