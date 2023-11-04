package case_study_2.furama_resort.view;

import case_study_2.furama_resort.controller.CustomerController;
import case_study_2.furama_resort.controller.EmployeeController;
import case_study_2.furama_resort.model.person.Customer;
import case_study_2.furama_resort.model.person.Employee;
import case_study_2.furama_resort.model.person.Person;
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
                System.out.println("1.Display list employees\n" +
                        "2.Add new employee\n" +
                        "3.Edit employee\n" +
                        "4.Delete employee\n" +
                        "5.Search by name employee\n" +
                        "6.Return main menu");
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
        System.out.println("Nhập mã nhân viên bạn muốn sửa");
        String employeeCode;
        Person person;
        String level;
        String location;
        Integer wage;
        try {
            do {
                employeeCode = scanner.nextLine();
                if (PersonInforExample.validateEmployeeCode(employeeCode) && employeeController.checkObjectCode(employeeCode)) {
                    System.out.println("Hãy nhập lại thông tin bạn cần sửa");
                    person = inputPersonInfor();
                    level = inputEmployeeLevel();
                    location = inputEmployeeLocation();
                    wage = inputEmployeeWage();
                    employeeController.editObject(new Employee(employeeCode, level, location, wage), person);
                    System.out.println("Bạn đã sửa thành công");
                    return;
                } else {
                    System.out.println("Mã không hợp lệ hoặc không tồn tại!\n" +
                            "Xin hãy nhập lại");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        String employeeCode;
        String level;
        String location;
        Integer wage;
        try {
            person = inputPersonInfor();
            employeeCode = inputEmployeeCode();
            level = inputEmployeeLevel();
            location = inputEmployeeLocation();
            wage = inputEmployeeWage();
            employeeController.addObject(new Employee(employeeCode, level, location, wage), person);
            System.out.println("Bạn đã thêm thành công!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static Person inputPersonInfor() {
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
        return new Person(name, dateOfBirth, gender, numberCMND, phoneNumber, email);
    }

    public static Integer inputEmployeeWage() {
        System.out.println("Nhập lương nhân viên");
        Integer wage;
        do {
            wage = Integer.parseInt(scanner.nextLine());
            if (!PersonInforExample.validateEmployeeWage(wage)) {
                System.out.println("Không hợp lệ!\n" +
                        "Xin mời nhập lại!");
            }
        } while (!PersonInforExample.validateEmployeeWage(wage));
        return wage;
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
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return "Lễ tân";
                case 2:
                    return "Phục vụ";
                case 3:
                    return "Chuyên viên";
                case 4:
                    return "Giám sát";
                case 5:
                    return "Quản lý";
                case 6:
                    return "Giám đốc";
                default:
                    System.out.println("Chỉ được chọn từ 1 đến 6!!!");
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
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return "Trung Cấp";
                case 2:
                    return "Cao Đẳng";
                case 3:
                    return "Đại Học";
                case 4:
                    return "Sau Đại Học";
                default:
                    System.out.println("Chỉ được chọn từ 1 đến 4!!!");
            }
        } while (true);
    }

    public static String inputEmployeeCode() {
        String employeeCode;
        System.out.println("Nhập mã nhân viên");
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
        System.out.println("Nhập email:");
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
        System.out.println("Nhập CMND:");
        do {

            numberCMND = scanner.nextLine();
            if (!PersonInforExample.validateNumberCmnd(numberCMND)) {
                System.out.println("Không hợp lệ!\n" +
                        "Xin mời nhập lại!");
            }
        } while (!PersonInforExample.validateNumberCmnd(numberCMND));
        return numberCMND;
    }

    public static String inputPersonGender() {
        System.out.println("Chọn giới tính.\n" +
                "1.Nam\n" +
                "2.Nữ");
        int i;
        do {
            i = Integer.parseInt(scanner.nextLine());
            switch (i) {
                case 1:
                    return "Nam";
                case 2:
                    return "Nữ";
                default:
                    System.out.println("Chỉ được chọn 1 hoặc 2!!!");
            }
        } while (true);
    }

    public static String inputPersonDateOfBirth() {
        String dateOfBirth;
        System.out.println("Nhập ngày tháng năm sinh:");
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
        System.out.println("Nhập tên:");
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
                System.out.println("1.Display list customers\n" +
                        "2.Add new customer\n" +
                        "3.Edit customer\n" +
                        "4.Delete customer\n" +
                        "5.Search by name customer\n" +
                        "6.Return main menu");
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
        System.out.println("Nhập mã khách hàng cần sữa:");
        Person person;
        String customerCode;
        String guestType;
        String address;
        try {
            do {
                customerCode = scanner.nextLine();
                if (PersonInforExample.validateCustomerCode(customerCode) && customerController.checkObjectCode(customerCode)) {
                    System.out.println("Hãy nhập thông tin cần sữa");
                    person = inputPersonInfor();
                    guestType = inputGuestType();
                    address = getAddress(guestType);
                    customerController.editObject(new Customer(customerCode, guestType, address), person);
                    System.out.println("Bạn đã sữa thành công!");
                    return;
                } else {
                    System.out.println("Mã khách hàng bạn nhập không đúng hoặc không tồn tại!\n" +
                            "Xin hãy nhập lại!");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addNewCustomer() {
        Person person;
        String customerCode;
        String guestType;
        String address;
        try {
            person = inputPersonInfor();
            customerCode = inputCustomerCode();
            guestType = inputGuestType();
            address = getAddress(guestType);
            customerController.addObject(new Customer(customerCode, guestType, address), person);
            System.out.println("Bạn đã thêm thành công!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getAddress(String guestType) {
        String address = null;
        switch (guestType) {
            case "Diamond":
                address = "Ngoại ô";
                break;
            case "Platinum":
                address = "Bờ biển";
                break;
            case "Gold":
                address = "Trung tâm thành phố";
                break;
            case "Silver":
                address = "Giữa trung tâm thành phố";
                break;
            case "Member":
                address = "Hòn đảo";
                break;
        }
        return address;
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
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return "Diamond";
                case 2:
                    return "Platinum";
                case 3:
                    return "Gold";
                case 4:
                    return "Silver";
                case 5:
                    return "Member";
                default:
                    System.out.println("Chỉ được nhập từ 1 đến 5");
            }
        } while (true);

    }

    public static String inputCustomerCode() {
        String customerCode;
        System.out.println("Nhập mã khách hàng");
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
                        ", email='" + customer.getEmail() + '\''+
                        ", guestType='" + customer.getGuestType() + '\'' +
                        ", address='" + customer.getAddress() + '\''+ ", ");
            }
        }
    }
}
