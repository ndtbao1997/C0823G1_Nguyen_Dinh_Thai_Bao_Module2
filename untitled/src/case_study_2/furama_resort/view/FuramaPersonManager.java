package case_study_2.furama_resort.view;

import case_study_2.furama_resort.controller.CustomerController;
import case_study_2.furama_resort.controller.EmployeeController;
import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Employee;
import case_study_2.furama_resort.model.person.Person;
import case_study_2.furama_resort.untils.enum_furama.EnumFurama;
import case_study_2.furama_resort.untils.validate.PersonInforExample;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FuramaPersonManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeController employeeController = new EmployeeController();
    private static final CustomerController customerController = new CustomerController();

    public static void displayEmployeeManagement() {
        int choice;
        try {
            do {
                System.out.println("1.Hiển thị danh sách nhân viên\n" +
                        "2.Thêm nhân viên mới\n" +
                        "3.Chỉnh sửa nhân viên\n" +
                        "4.Xóa nhân viên\n" +
                        "5.Tìm theo tên nhân viên\n" +
                        "6.Quay lại");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayListEmployee();
                        break;
                    case 2:
                        addNewEmployee();
                        break;
                    case 3:
                        editEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        searchEmployeeByName();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Xin vui lòng nhập lại");
                }
            } while (true);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void searchEmployeeByName() {
        String name;
        do {
            System.out.println("Nhập tên nhân viên bạn muốn tìm!");
            name = scanner.nextLine();
        } while (Objects.equals(name, ""));
        List<Employee> employeeList = employeeController.searchObjectByName(name);
        if (employeeList.isEmpty()) {
            System.out.println("Không có sản phẩm nào được tìm thấy");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }

    public static void deleteEmployee() {
        System.out.println("Nhập mã nhân viên bạn muốn xóa:");
        String employeeCode;
        do {
            employeeCode = scanner.nextLine();
            if (PersonInforExample.validateEmployeeCode(employeeCode) && employeeController.checkObjectCode(employeeCode)) {
                confirmDeleteEmployee(employeeCode);
                return;
            } else {
                System.out.println("Mã không hợp lệ hoặc không tồn tại!\n" +
                        "Xin nhập lại.");
            }
        } while (true);
    }

    public static void confirmDeleteEmployee(String employeeCode) {
        System.out.println("1.Đồng ý\n" +
                "2.Hủy xóa");
        int choice;
        do {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeController.deleteObject(employeeCode);
                    System.out.println("Bạn đã xóa thành công1");
                    return;
                case 2:
                    System.out.println("Bạn đã hủy xóa!");
                    return;
                default:
                    System.out.println("Chỉ được chọn 1 hoặc 2!");
            }
        } while (true);
    }

    public static void editEmployee() {
        int choice;
        String employeeCode;
        do {
            try {
                System.out.println("Nhập mã nhân viên bạn muốn sửa (định dạng NV-XXXX):");
                employeeCode = scanner.nextLine();
                if (PersonInforExample.validateEmployeeCode(employeeCode) && employeeController.checkObjectCode(employeeCode)) {
                    System.out.println("Hãy chọn nội dung bạn muốn sửa (chỉ được nhập từ 1-10):\n" +
                            "1.Tên \n" +
                            "2.Ngày sinh\n" +
                            "3.Giới tính\n" +
                            "4.Số CMND\n" +
                            "5.Số điện thoại\n" +
                            "6.Email\n" +
                            "7.Trình độ\n" +
                            "8.Vị trí\n" +
                            "9.Lương\n" +
                            "10.Quay lại");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            editEmployeeName(employeeCode);
                            return;
                        case 2:
                            editEmployeeDateOfBirth(employeeCode);
                            return;
                        case 3:
                            editEmployeeGenger(employeeCode);
                            return;
                        case 4:
                            editEmployeeNumberCmnd(employeeCode);
                            return;
                        case 5:
                            editEmployeePhonenumber(employeeCode);
                            return;
                        case 6:
                            editEmployeeEmail(employeeCode);
                            return;
                        case 7:
                            editEmployeeLevel(employeeCode);
                            return;
                        case 8:
                            editEmployeeLocation(employeeCode);
                            return;
                        case 9:
                            editEmployeeWage(employeeCode);
                            return;
                        case 10:
                            return;
                    }
                } else {
                    System.out.println("Mã không hợp lệ hoặc không tồn tại!\n" +
                            "Xin hãy nhập lại");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private static void editEmployeeWage(String employeeCode) {
        Integer wage = inputEmployeeWage();
        employeeController.editEmployeeWage(employeeCode, wage);
        System.out.println("Sửa thành công");
    }

    private static void editEmployeeLocation(String employeeCode) {
        String location = inputEmployeeLocation();
        employeeController.editEmployeeLocation(employeeCode, location);
        System.out.println("Sửa thành công");
    }

    private static void editEmployeeLevel(String employeeCode) {
        String level = inputEmployeeLevel();
        employeeController.editEmployeeLevel(employeeCode, level);
        System.out.println("Sửa thành công");
    }

    private static void editEmployeeEmail(String employeeCode) {
        String email = inputPersonEmail();
        employeeController.editEmployeeMail(employeeCode, email);
        System.out.println("Sửa thành công");
    }

    private static void editEmployeePhonenumber(String employeeCode) {
        String phoneNumber = inputPersonPhoneNumber();
        employeeController.editEmployeePhoneNumber(employeeCode, phoneNumber);
        System.out.println("Sửa thành công");
    }

    private static void editEmployeeNumberCmnd(String employeeCode) {
        String numberCmnd = inputPersonNumberCmnd();
        employeeController.editEmployeeNumberCmnd(employeeCode, numberCmnd);
        System.out.println("Sửa thành công");
    }

    private static void editEmployeeGenger(String employeeCode) {
        String gender = inputPersonGender();
        employeeController.editEmployeeGender(employeeCode, gender);
        System.out.println("Sửa thành công");
    }

    private static void editEmployeeDateOfBirth(String employeeCode) {
        String dateOfBirth = inputPersonDateOfBirth();
        employeeController.editEmployeeDateOfBirth(employeeCode, dateOfBirth);
        System.out.println("Sửa thành công");
    }

    private static void editEmployeeName(String employeeCode) {
        String name = inputPersonName();
        employeeController.editEmployeeName(employeeCode, name);
        System.out.println("Sửa thành công");
    }

    public static void displayListEmployee() {
        List<Employee> employeeList = employeeController.getAll();
        if (employeeList.isEmpty()) {
            System.out.println("Danh sách nhân viên hiện tại trống");
        } else {
            for (Employee employee : employeeList) {
                System.out.println("employeeCode='" + employee.getEmployeeCode() + '\'' +
                        ", level='" + employee.getLevel() + '\'' +
                        ", location='" + employee.getLocation() + '\'' +
                        ", wage='" + employee.getWage() + '\'' + ", " +
                        "name='" + employee.getName() + '\'' +
                        ", dateOfBirth='" + employee.getDateOfBirth() + '\'' +
                        ", gender='" + employee.getGender() + '\'' +
                        ", numberCMND='" + employee.getNumberCMND() + '\'' +
                        ", phoneNumber='" + employee.getPhoneNumber() + '\'' +
                        ", email='" + employee.getEmail() + '\'');
            }
        }
    }

    public static void addNewEmployee() {
        Person person;
        Person person1;
        String employeeCode;
        String level;
        String location;
        Integer wage;
        try {
            person = inputPersonInfor(1);
            employeeCode = inputEmployeeCode();
            level = inputEmployeeLevel();
            location = inputEmployeeLocation();
            wage = inputEmployeeWage();
            person1 = new Employee(employeeCode, level, location, wage);
            employeeController.addObject(person1, person);
            System.out.println("Bạn đã thêm thành công!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static Person inputPersonInfor(int i) {
        String gender;
        String name;
        String email;
        String dateOfBirth;
        String numberCMND;
        String phoneNumber;
        name = inputPersonName();
        dateOfBirth = inputPersonDateOfBirth();
        gender = inputPersonGender();
        numberCMND = inputPersonNumberCmnd();
        phoneNumber = inputPersonPhoneNumber();
        email = inputPersonEmail();
        if (i == 1) {
            return new Employee(name, dateOfBirth, gender, numberCMND, phoneNumber, email);
        } else {
            return new Customer(name, dateOfBirth, gender, numberCMND, phoneNumber, email);
        }
    }

    public static Integer inputEmployeeWage() {
        System.out.println("Nhập lương nhân viên (phải lớn hơn 0)");
        Integer wage;
        do {
            try {
                wage = Integer.parseInt(scanner.nextLine());
                if (!PersonInforExample.validateEmployeeWage(wage)) {
                    System.out.println("Không hợp lệ!\n" +
                            "Xin mời nhập lại!");
                } else {
                    return wage;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public static String inputEmployeeLocation() {
        int choice;
        System.out.println("Chọn cấp bậc nhân viên.\n" +
                "1. Lễ tân\n" +
                "2. Phục vụ\n" +
                "3. Chuyên viên\n" +
                "4. Giám sát\n" +
                "5. Quản lý\n" +
                "6. Giám đốc");
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return EnumFurama.RECEPTIONIST.getValue();
                    case 2:
                        return EnumFurama.SERVE.getValue();
                    case 3:
                        return EnumFurama.EXPERT.getValue();
                    case 4:
                        return EnumFurama.MONITOR.getValue();
                    case 5:
                        return EnumFurama.MANAGE.getValue();
                    case 6:
                        return EnumFurama.MANAGER.getValue();
                    default:
                        System.out.println("Chỉ được chọn từ 1 đến 6!!!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public static String inputEmployeeLevel() {
        int choice;
        System.out.println("Chọn level nhân viên:\n" +
                "1.Trung Cấp\n" +
                "2.Cao Đẳng\n" +
                "3.Đại Học\n" +
                "4.Sau Đại Học");
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return EnumFurama.INTERMEDIATE.getValue();
                    case 2:
                        return EnumFurama.COLLEGE.getValue();
                    case 3:
                        return EnumFurama.UNIVERSITY.getValue();
                    case 4:
                        return EnumFurama.AFTER_UNIVERSITY.getValue();
                    default:
                        System.out.println("Chỉ được chọn từ 1 đến 4!!!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public static String inputEmployeeCode() {
        String employeeCode;
        System.out.println("Nhập mã nhân viên (định dạng NV-XXXX):");
        do {
            employeeCode = scanner.nextLine();
            if (PersonInforExample.validateEmployeeCode(employeeCode) && (!employeeController.checkObjectCode(employeeCode))) {
                break;
            } else {
                System.out.println("Không hợp lệ hoặc đã tồn tại!\n" +
                        "Xin mời nhập lại!");
            }
        } while (true);
        return employeeCode;
    }

    public static String inputPersonEmail() {
        String email;
        System.out.println("Nhập email (độ dài từ 6-50 kí tự):");
        do {
            email = scanner.nextLine();
            if (!PersonInforExample.validateMail(email)) {
                System.out.println("Không hợp lệ!\n" +
                        "Xin mời nhập lại!");
            }
        } while (!PersonInforExample.validateMail(email));
        return email;
    }

    public static String inputPersonPhoneNumber() {
        String phoneNumber;
        System.out.println("Nhập số điện thoại");
        do {
            phoneNumber = scanner.nextLine();
            if (!PersonInforExample.validatePhoneNumber(phoneNumber)) {
                System.out.println("Không hợp lệ!\n" +
                        "Xin mời nhập lại!");
            }
        } while (!PersonInforExample.validatePhoneNumber(phoneNumber));
        return phoneNumber;
    }

    public static String inputPersonNumberCmnd() {
        String numberCMND;
        System.out.println("Nhập CMND (phải có từ 9-12 chữ số):");
        do {
            numberCMND = scanner.nextLine();
            if (!PersonInforExample.validateNumberCmnd(numberCMND) ||
                    customerController.checkObjectNumberCmnd(numberCMND) ||
                    employeeController.checkObjectNumberCmnd(numberCMND)) {
                System.out.println("Không hợp lệ hoặc đã tồn tại!\n" +
                        "Xin mời nhập lại!");
            } else {
                return numberCMND;
            }
        } while (true);
    }

    public static String inputPersonGender() {
        System.out.println("Chọn giới tính.\n" +
                "1.Nam\n" +
                "2.Nữ");
        int i;
        do {
            try {
                i = Integer.parseInt(scanner.nextLine());
                switch (i) {
                    case 1:
                        return EnumFurama.MALE.getValue();
                    case 2:
                        return EnumFurama.FEMALE.getValue();
                    default:
                        System.out.println("Chỉ được chọn 1 hoặc 2!!!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public static String inputPersonDateOfBirth() {
        String dateOfBirth;
        System.out.println("Nhập ngày tháng năm sinh (định dạng dd/xx/yyyy) :");
        do {
            dateOfBirth = scanner.nextLine();
            if (!PersonInforExample.validateDateOfBirth(dateOfBirth)) {
                System.out.println("Không hợp lệ!\n" +
                        "Xin mời nhập lại!");
            }
        } while (!PersonInforExample.validateDateOfBirth(dateOfBirth));
        return dateOfBirth;
    }

    public static String inputPersonName() {
        String name;
        System.out.println("Nhập tên (chữ cái đầu tiên phải viết hoa và độ dài không vượt quá 50 kí tự):");
        do {
            name = scanner.nextLine();
            if (!PersonInforExample.validateName(name)) {
                System.out.println("Không hợp lệ!\n" +
                        "Xin mời nhập lại!");
            }
        } while (!PersonInforExample.validateName(name));
        return name;
    }

    public static void displayCustomerManagement() {
        int choice;
        try {
            do {
                System.out.println("1.Hiển thị danh sách khách hàng\n" +
                        "2.Thêm khách hàng mới\n" +
                        "3.Edit customer\n" +
                        "4.Xóa khách hàng\n" +
                        "5.Tìm kiếm theo tên khách hàng\n" +
                        "6.Quay lại Menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        displayListCustomer();
                        break;
                    case 2:
                        addNewCustomer();
                        break;
                    case 3:
                        editCustomer();
                        break;
                    case 4:
                        deleteCustomer();
                        break;
                    case 5:
                        searchCustomerByName();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Xin vui lòng nhập lại\n");
                }
            } while (true);
        } catch (Exception e) {
            System.err.println("Thao tác không hợp lệ!!!\n");
        }
    }

    public static void searchCustomerByName() {
        System.out.println("Hãy nhập tên khách hàng bạn muốn tìm:");
        String name = scanner.nextLine();
        List<Customer> customerList = customerController.searchObjectByName(name);
        if (customerList.isEmpty()) {
            System.out.println("Không có sản phẩm nào được tìm thấy!");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    public static void deleteCustomer() {
        System.out.println("Hãy nhập mã khách hàng bạn muốn xóa:");
        String customerCode;
        do {
            customerCode = scanner.nextLine();
            if (PersonInforExample.validateCustomerCode(customerCode) && customerController.checkObjectCode(customerCode)) {
                confirmDeleteCustomer(customerCode);
                return;
            } else {
                System.out.println("Mã khách hàng khoog đúng hoặc không tồn tại!\n" +
                        "Xin mời nhập lại");
            }
        } while (true);
    }

    public static void confirmDeleteCustomer(String customerCode) {
        int choice;
        System.out.println("1.Xóa khách hàng\n" +
                "2.Hủy xóa");
        do {
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerController.deleteObject(customerCode);
                    System.out.println("Bạn đã xóa thành công!");
                    return;
                case 2:
                    System.out.println("Bạn đã hủy xóa!");
                    return;
                default:
                    System.out.println("Chỉ được nhập 1 hoặc 2.");
            }
        } while (true);
    }

    public static void editCustomer() {
        int choice;
        String customerCode;
        do {
            try {
                System.out.println("Nhập mã khách hàng cần sữa:");
                customerCode = scanner.nextLine();
                if (PersonInforExample.validateCustomerCode(customerCode) && customerController.checkObjectCode(customerCode)) {
                    System.out.println("Hãy chọn nội dung bạn muốn sửa (chỉ được nhập từ 1-8):\n" +
                            "1.Tên \n" +
                            "2.Ngày sinh\n" +
                            "3.Giới tính\n" +
                            "4.Số CMND\n" +
                            "5.Số điện thoại\n" +
                            "6.Email\n" +
                            "7.Loại khách hàng\n" +
                            "8.Quay lại");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            editCustomerName(customerCode);
                            return;
                        case 2:
                            editCustomerDateOfBirth(customerCode);
                            return;
                        case 3:
                            editCustomerGender(customerCode);
                            return;
                        case 4:
                            editCustomerNumberCmnd(customerCode);
                            return;
                        case 5:
                            editCustomerPhoneNumber(customerCode);
                            return;
                        case 6:
                            editCustomerEmail(customerCode);
                            return;
                        case 7:
                            editCustomerGuestType(customerCode);
                            return;
                        case 8:
                            return;
                    }
                    return;
                } else {
                    System.out.println("Mã khách hàng bạn nhập không đúng hoặc không tồn tại!\n" +
                            "Xin hãy nhập lại!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private static void editCustomerGuestType(String customerCode) {
        String guestType = inputGuestType();
        String address = getAddress(guestType);
        customerController.editCustomerGuestType(customerCode, guestType, address);
        System.out.println("Sửa thành công");
    }

    private static void editCustomerEmail(String customerCode) {
        String email = inputPersonEmail();
        customerController.editCustomerEmai(customerCode,email);
        System.out.println("Sửa thành công");
    }

    private static void editCustomerPhoneNumber(String customerCode) {
        String phoneNumber = inputPersonPhoneNumber();
        customerController.editCustomerPhoneNumber(customerCode,phoneNumber);
        System.out.println("Sửa thành công");
    }

    private static void editCustomerGender(String customerCode) {
        String gender = inputPersonGender();
        customerController.editCustomerGender(customerCode,gender);
        System.out.println("Sửa thành công");
    }

    private static void editCustomerDateOfBirth(String customerCode) {
        String dateOfBirth = inputPersonDateOfBirth();
        customerController.editCustomerDateOfBirth(customerCode,dateOfBirth);
        System.out.println("Sửa thành công");
    }

    private static void editCustomerNumberCmnd(String customerCode) {
        String numberCmnd = inputPersonNumberCmnd();
        customerController.editCustomerNumberCmnd(customerCode,numberCmnd);
        System.out.println("Sửa thành công");
    }

    private static void editCustomerName(String customerCode) {
        String name = inputPersonName();
        customerController.editCustomerName(customerCode,name);
        System.out.println("Sửa thành công");
    }

    public static void addNewCustomer() {
        Person person;
        Person person1;
        String customerCode;
        String guestType;
        String address;
        try {
            person = inputPersonInfor(2);
            customerCode = inputCustomerCode();
            guestType = inputGuestType();
            address = getAddress(guestType);
            person1 = new Customer(customerCode, guestType, address);
            customerController.addObject(person1, person);
            System.out.println("Bạn đã thêm thành công!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getAddress(String guestType) {
        return switch (guestType) {
            case "Diamond" -> EnumFurama.SUBURBAN.getValue();
            case "Platinum" -> EnumFurama.COAST.getValue();
            case "Gold" -> EnumFurama.DOWNTOWN.getValue();
            case "Silver" -> EnumFurama.MIDDLE_DOWNTOWN.getValue();
            case "Member" -> EnumFurama.ISLAND.getValue();
            default -> null;
        };
    }

    public static String inputGuestType() {
        int choice;
        System.out.println("Hãy chọn loại khách hàng\n" +
                "1.Diamond\n" +
                "2.Platinum\n" +
                "3.Gold\n" +
                "4.Silver\n" +
                "5.Member");
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return EnumFurama.DIAMOND.getValue();
                    case 2:
                        return EnumFurama.PLATINUM.getValue();
                    case 3:
                        return EnumFurama.GOLD.getValue();
                    case 4:
                        return EnumFurama.SILVER.getValue();
                    case 5:
                        return EnumFurama.MEMBER.getValue();
                    default:
                        System.out.println("Chỉ được nhập từ 1 đến 5");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

    }

    public static String inputCustomerCode() {
        String customerCode;
        System.out.println("Nhập mã khách hàng (định dạng KH-XXXX):");
        do {
            customerCode = scanner.nextLine();
            if ((!customerController.checkObjectCode(customerCode)) && PersonInforExample.validateCustomerCode(customerCode)) {
                return customerCode;
            } else {
                System.out.println("Mã không hợp lê hoặc đã tồn tại.\n" +
                        "Xin nhập lại!");
            }
        } while (true);
    }

    public static void displayListCustomer() {
        List<Customer> customerList = customerController.getAll();
        if (customerList.isEmpty()) {
            System.out.println("Hiện tại không có khách hàng nào cả!");
        } else {
            for (Customer customer : customerList) {
                System.out.println("customerCode='" + customer.getCustomerCode() + '\'' +
                        ", name='" + customer.getName() + '\'' +
                        ", dateOfBirth='" + customer.getDateOfBirth() + '\'' +
                        ", gender='" + customer.getGender() + '\'' +
                        ", numberCMND='" + customer.getNumberCMND() + '\'' +
                        ", phoneNumber='" + customer.getPhoneNumber() + '\'' +
                        ", email='" + customer.getEmail() + '\'' +
                        ", guestType='" + customer.getGuestType() + '\'' +
                        ", address='" + customer.getAddress() + '\'' + ", ");
            }
        }
    }
}
