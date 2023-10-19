package ss8_clean_code.mvc.repository;


import ss8_clean_code.mvc.model.Student;

import java.util.Scanner;

public class StudentRepository implements IStudentRepository {
    Scanner scanner = new Scanner(System.in);
    private static Student[] students = new Student[6];

    static {
        students[0] = new Student(1, "Dụng");
        students[1] = new Student(2, "Tuấn");
        students[2] = new Student(3, "Vi");
        students[3] = new Student(4, "Độ");
        students[4] = new Student(5, "Hải");
    }

    @Override
    public void showList() {
        for (Student s : students) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void addStudent(int id, String name) {
        if (students[students.length - 1] != null) {
            Student[] newStudens = new Student[students.length * 2];
            System.arraycopy(students, 0, newStudens, 0, students.length);
            students = newStudens;
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = new Student(id, name);
                break;
            }
        }
    }

    @Override
    public void removeStudent(int id) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Id bạn nhập vào không tồn tại");
        } else {
            for (int k = index; k < students.length-1; k++) {
                students[k] = students[k + 1];
            }
            students[students.length - 1] = null;
        }
    }

    @Override
    public void editStudent(int id) {
        int index = checkId(id);
        int newId;
        String newName;
        if (index == -1){
            System.out.println("Id bạn nhập không tồn tại");
        } else {
            System.out.println("Hãy nhập Id bạn muốn sữa");
            newId = Integer.parseInt(scanner.nextLine());
            System.out.println("Hãy nhập Tên bạn muốn sữa");
            newName = scanner.nextLine();
            students[index].setId(newId);
            students[index].setName(newName);
        }
    }
    public int checkId(int id){
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id){
                return i;
            }
        }
        return -1;
    }
}
