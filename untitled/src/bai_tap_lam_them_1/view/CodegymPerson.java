package bai_tap_lam_them_1.view;

import bai_tap_lam_them_1.controller.PersonController;

import java.util.Scanner;

public class CodegymPerson {
    private static Scanner scanner = new Scanner(System.in);

    private static PersonController personController = new PersonController();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN –-\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới học sinh\n" +
                    "2. Thêm mới giảng viên\n" +
                    "3. Xóa học sinh\n" +
                    "4. Xóa giảng viên\n" +
                    "5. Xem danh sách học sinh\n" +
                    "6. Xem danh sách giảng viên\n" +
                    "7. Thoát\n" +
                    "Chọn chức năng:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    removeTeacher();
                    break;
                case 5:
                    personController.displayStudents();
                    break;
                case 6:
                    personController.displayTeacher();
                    break;
                case 7:
                    System.out.println("Hẹn gặp lại");
                    System.exit(7);
                default:
                    System.out.println("Bạn đã nhập sai. Xin hãy nhập lại.");
            }
        } while (true);
    }

    private static void addStudent(){
        System.out.println("Mã học sinh");
        String id = scanner.nextLine();
        System.out.println("Tên học sinh");
        String name = scanner.nextLine();
        System.out.println("Ngày sinh của học sinh");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Giới tính");
        String gender = scanner.nextLine();
        System.out.println("Lớp của học sinh");
        String className = scanner.nextLine();
        System.out.println("Điểm học sinh");
        int scores = Integer.parseInt(scanner.nextLine());
        personController.addStudent(id,name,dateOfBirth,gender,className,scores);
    }
    private static void addTeacher(){
        System.out.println("Mã giảng viên");
        String id = scanner.nextLine();
        System.out.println("Tên giảng viên");
        String name = scanner.nextLine();
        System.out.println("Ngày sinh của giảng viên");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Giới tính");
        String gender = scanner.nextLine();
        System.out.println("Trình độ giảng viên");
        String level = scanner.nextLine();
        personController.addTeacher(id,name,dateOfBirth,gender,level);
    }
    private static void removeStudent(){
        String id;
        System.out.println("Hãy nhập id học viên bạn muốn xóa");
        id = scanner.nextLine();
        personController.removeStudent(id);
    }
    private static void removeTeacher(){
        String id;
        System.out.println("Hãy nhập id giảng viên bạn muốn xóa");
        id = scanner.nextLine();
        personController.removeTeacher(id);
    }
}

