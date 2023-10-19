package ss8_clean_code.mvc.view;



import ss8_clean_code.mvc.controller.StudentController;

import java.util.Scanner;

public class CodegymManagement {
    private static final Scanner  scanner = new Scanner(System.in);
    private static StudentController studentController = new StudentController();
    public static void main(String[] args) {
        int choice;
        int id;
        do{
            System.out.println("Vui lòng chọn chức năng:\n" +
                    "1. Xem danh sách.\n" +
                    "2. Thêm mới học viên. \n" +
                    "3. Sửa học viên. \n" +
                    "4. Xóa học viên. \n" +
                    "5. Thoát chương trình");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    studentController.showList();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    System.out.println("Hẹn gặp lại \n");
                    System.exit(1);
                default:
                    System.out.println("Vui lòng chọn đúng số trong danh sách chức năng \n");
            }
        }while (true);

    }

    private static void removeStudent() {
        int id;
        System.out.println("Hãy nhập vào id bạn muốn xóa");
        id = Integer.parseInt(scanner.nextLine());
        studentController.removeStudent(id);
    }

    private static void editStudent() {
        int id;
        System.out.println("Hãy nhập vào id bạn muốn sửa");
        id = Integer.parseInt(scanner.nextLine());
        studentController.editStudent(id);
    }

    private static void addStudent() {
        String name;
        int id;
        System.out.println("Bạn hãy nhập id của học viên bạn muốn thêm");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập tên học viên bạn muốn thêm");
        name = scanner.nextLine();
        studentController.addStudent(id,name);
    }
}
