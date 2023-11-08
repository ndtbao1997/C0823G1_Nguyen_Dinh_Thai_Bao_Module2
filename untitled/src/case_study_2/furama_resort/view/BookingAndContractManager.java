package case_study_2.furama_resort.view;

import case_study_2.furama_resort.controller.*;
import case_study_2.furama_resort.model.booking_contract.Booking;
import case_study_2.furama_resort.model.booking_contract.Contract;
import case_study_2.furama_resort.untils.validate.BookingInforExample;
import case_study_2.furama_resort.untils.validate.FacilityInforExample;
import case_study_2.furama_resort.untils.validate.PersonInforExample;

import java.time.LocalDate;
import java.util.*;

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
        Double advanceDepositAmount;
        Double totalPaymentAmount;
        String bookingCode;
        System.out.println("Nhập mã số hợp đồng bạn cần sửa (định dạng XXXXX, X từ 0-9)");
        do {
            try {
                someContract = scanner.nextLine();
                if (BookingInforExample.validateSomeContracts(someContract) && contactController.checkObjectCode(someContract)) {
                    bookingCode = contactController.getBookingCode(someContract);
                    totalPaymentAmount = inputTotalPaymentAmount(bookingCode);
                    advanceDepositAmount = inputAdvanceDepositAmount(bookingCode, totalPaymentAmount);
                    if((contactController.checkObjectCode(someContract)) && bookingController.checkObjectCode(bookingCode)){
                        contactController.editObject(new Contract(someContract, bookingCode, advanceDepositAmount, totalPaymentAmount));
                        System.out.println("Bạn đã sửa thành công");
                    } else {
                        System.out.println("Hợp đồng đã bị xóa hoặc mã booking đã bị hủy! Xin xác nhận lại!");
                    }
                    return;
                } else {
                    System.out.println("Không hợp lệ hoặc không tồn tại!\n" +
                            "Xin nhập lại");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
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
        Double advanceDepositAmount;
        Double totalPaymentAmount;
        while (!bookingQueue.isEmpty()) {
            try {
                bookingCode = bookingQueue.peek().getBookingCode();
                if (contactController.checkObjectCode(bookingCode)) {
                    bookingQueue.poll();
                } else {
                    someContracts = inputSomeContracts();
                    totalPaymentAmount = inputTotalPaymentAmount(bookingCode);
                    advanceDepositAmount = inputAdvanceDepositAmount(bookingCode, totalPaymentAmount);
                    if ((!contactController.checkObjectCode(someContracts)) && bookingController.checkObjectCode(bookingCode)){
                        contactController.addObject(new Contract(someContracts, bookingCode, advanceDepositAmount, totalPaymentAmount));
                        System.out.println("Hợp đồng của " + bookingCode + " đã được tạo thành công");
                    } else {
                        System.out.println("Hợp đồng đã được tạo hoặc mã booking đã hủy! Xin bạn xác nhận lại");
                    }

                    bookingQueue.poll();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Tất cả hợp đồng đã hoàn tất");
    }

    public static Double inputTotalPaymentAmount(String bookingCode) {
        List<String> strings = bookingController.getInforBooking(bookingCode);
        String rentalType = facilityController.getRentalType(strings.get(2));
        Double rentalCosts = facilityController.getRentalCosts(strings.get(2));
        int totalDate = getTotalDate(strings);
        switch (rentalType) {
            case "Năm":
                getTotalDate(strings);
                return rentalCosts / 365 * (totalDate);
            case "Tháng":
                return rentalCosts / 30 * (totalDate);
            case "Ngày":
                return rentalCosts * totalDate;
            default:
                return rentalCosts;
        }
    }

    private static int getTotalDate(List<String> strings) {
        int date;
        String[] startDate;
        String[] endDate;
        int year;
        int totalDate;
        int month;
        startDate = strings.get(0).split("/");
        endDate = strings.get(1).split("/");
        year = Integer.parseInt(endDate[2]) - Integer.parseInt(startDate[2]);
        if (Integer.parseInt(endDate[1]) < Integer.parseInt(startDate[1])) {
            month = Integer.parseInt(endDate[1]) + 12 - Integer.parseInt(startDate[1]);
            year = year - 1;
        } else {
            month = Integer.parseInt(endDate[1]) - Integer.parseInt(startDate[1]);
        }
        if (Integer.parseInt(endDate[0]) < Integer.parseInt(startDate[0])) {
            date = Integer.parseInt(endDate[0]) + 30 - Integer.parseInt(startDate[0]);
            month = month - 1;
        } else {
            date = Integer.parseInt(endDate[0]) - Integer.parseInt(startDate[0]);
        }
        totalDate = year * 365 + month * 30 + date;
        return totalDate;
    }

    public static Double inputAdvanceDepositAmount(String bookingCode, Double totalPaymentAmount) {
        Double advanceDepositAmount;
        System.out.println("Nhập số tiền thanh toán trước của " + bookingCode + " \n" +
                "(phải lớn hơn 30% tổng số tiền là " + (totalPaymentAmount * 30 / 100) +
                " và nhỏ hơn hoặc bằng " + totalPaymentAmount + " )");
        do {
            try {
                advanceDepositAmount = Double.parseDouble(scanner.nextLine());
                if ((advanceDepositAmount > (totalPaymentAmount*30/100)) && (advanceDepositAmount <= totalPaymentAmount)) {
                    return advanceDepositAmount;
                } else {
                    System.out.println("Xin nhập lại");
                }
            } catch (Exception e) {
                System.err.println("Xin nhập lại");
            }
        } while (true);
    }

    public static String inputSomeContracts() {
        String someContracts;
        int some;
        List<Contract> contractList = contactController.getAll();
        if (contractList.isEmpty()) {
            someContracts = "00001";
        } else {
            some = Integer.parseInt(contractList.get(contractList.size() - 1).getSomeContracts()) + 1;
            if (some < 10) {
                someContracts = "0000" + some;
            } else if (some < 100) {
                someContracts = "000" + some;
            } else if (some < 1000) {
                someContracts = "00" + some;
            } else if (some < 10000) {
                someContracts = "0" + some;
            } else {
                someContracts = String.valueOf(some);
            }
        }
        return someContracts;
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
            bookingCode = getBookingCode();
            dateBooking = inputDateBooking();
            rentalStartDate = inputRentalStarDate(dateBooking);
            rentalEndDate = inputRentalEndDate(rentalStartDate);
            if(customerController.checkObjectCode(customerCode) && facilityController.checkObjectCode(facilityCode) &&
                    (!facilityController.checkRepair(facilityCode)) && (!bookingController.checkFacilityCode(facilityCode))){
                bookingController.addObject(new Booking(bookingCode, dateBooking, rentalStartDate, rentalEndDate, customerCode, facilityCode));
                System.out.println("Bạn đã thêm thành công!");
                facilityController.addObject(facilityCode);
            } else {
                System.out.println("Có một số thông tin đã thay đổi. Bạn hãy kiểm tra lại các thông tin như: mã khách hàng," +
                        "mã dịch vụ, danh sách sách bảo trì,...");
            }

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

    public static String inputRentalStarDate(String dateBooking) {
        String rentalStartDate;
        String[] startDate;
        String[] dateBook;
        System.out.println("Nhập ngày bắt đầu (phải là ngày booking hoặc sau ngày booking 2 tuần):");
        do {
            rentalStartDate = scanner.nextLine();
            if (BookingInforExample.validateRentalDate(rentalStartDate, dateBooking)) {
                startDate = rentalStartDate.split("/");
                dateBook = dateBooking.split("/");
                if (Integer.parseInt(startDate[2]) == Integer.parseInt(dateBook[2])) {
                    if (Integer.parseInt(startDate[1]) == Integer.parseInt(dateBook[1])) {
                        if (Integer.parseInt(startDate[0]) - Integer.parseInt(dateBook[0]) <= 14) {
                            return rentalStartDate;
                        } else {
                            System.out.println("Phải là ngày booking hoặc sau ngày booking 2 tuần! Xin nhập lại!");
                        }
                    } else if (Integer.parseInt(startDate[1]) - Integer.parseInt(dateBook[1]) == 1) {
                        if ((Integer.parseInt(startDate[0]) + 30 - Integer.parseInt(dateBook[0])) <= 14) {
                            return rentalStartDate;
                        } else {
                            System.out.println("Phải là ngày booking hoặc sau ngày booking 2 tuần! Xin nhập lại!");
                        }
                    }
                }
            } else {
                System.out.println("Không hợp lệ!\n" +
                        "Xin nhập lại!");
            }
        } while (true);
    }

    public static String inputDateBooking() {
        String dateBooking;
        String dateNow = String.valueOf(LocalDate.now());
        String[] dateNowArr = dateNow.split("-");
        dateBooking = dateNowArr[2] + "/" + dateNowArr[1] + "/" + dateNowArr[0];
        return dateBooking;
    }

    public static String getBookingCode() {
        String bookingCode;
        List<Booking> bookingList;
        String[] strings;
        int code;
        Set<Booking> bookingSet = bookingController.getAll();
        if (bookingSet.isEmpty()) {
            bookingCode = "BK-0001";
        } else {
            bookingList = new ArrayList<>(bookingSet);
            strings = bookingList.get(bookingList.size() - 1).getBookingCode().split("-");
            code = Integer.parseInt(strings[1]) + 1;
            if (code < 10) {
                bookingCode = "BK-000" + code;
            } else if (code < 100) {
                bookingCode = "BK-00" + code;
            } else if (code < 1000) {
                bookingCode = "BK-0" + code;
            } else {
                bookingCode = "BK-" + code;
            }
        }
        return bookingCode;
    }

    public static String inputFacilityCodeBooking() {
        String facilityCode;
        System.out.println("Nhập mã dịch vụ (định dạng SVVL-XXXX hoặc SVHO-XXXX hoặc SVRO-XXXX)");
        do {
            facilityCode = scanner.nextLine();
            if (FacilityInforExample.validateServiceCode(facilityCode)) {
                if (facilityController.checkObjectCode(facilityCode)) {
                    if (!facilityController.checkRepair(facilityCode)) {
                        if (!bookingController.checkFacilityCode(facilityCode)) {
                            return facilityCode;
                        } else {
                            System.out.println("Hiện tại dịch vụ này không còn trống! Xin chọn dịch vụ khác");
                        }
                    } else {
                        System.out.println("Đang bảo trì. Xin chọn dịch vụ khác!");
                    }
                } else {
                    System.out.println("Không tồn tại. Xin nhập lại.");
                }
            } else {
                System.out.println("Không hợp lệ. Xin nhập lại.");
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
