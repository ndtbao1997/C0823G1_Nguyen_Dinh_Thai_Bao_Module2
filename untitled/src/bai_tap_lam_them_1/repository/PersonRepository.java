package bai_tap_lam_them_1.repository;

import bai_tap_lam_them_1.model.Person;
import bai_tap_lam_them_1.model.Student;
import bai_tap_lam_them_1.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PersonRepository implements IPersonRepository{
    private static List<Person> personList = new ArrayList<>();
    static {
        personList.add(new Student("ST-001","Nguyễn Trọng Hải","01/01/2000","Male","C0823G1",9));
        personList.add(new Student("ST-002","Nguyễn Minh Tuấn","01/01/2001","Male","C0823G1",8));
        personList.add(new Teacher("TC-001","Nguyễn Thanh Công","01/01/1990","Male","Đại học"));
        personList.add(new Teacher("TC-002","Trương Tấn Hải","01/01/1991","Male","Đại học"));
    }

    @Override
    public void addStudent(String id, String name, String dateOfBirth, String gender, String className, int scores) {
        personList.add(new Student(id,name,dateOfBirth,gender,className,scores));
        System.out.println("Bạn đã thêm học viên thành công \n");
    }

    @Override
    public void addTeacher(String id, String name, String dateOfBirth, String gender, String level) {
        personList.add(new Teacher(id,name,dateOfBirth,gender,level));
        System.out.println("Bạn đã thêm giảng viên thành công\n");
    }

    @Override
    public void removeStudent(String id) {
        for(Person x: personList){
            if (Objects.equals(x.getId(), id)){
                checkYesOrNo(x);
                return;
            }
        }
        System.out.println("Id bạn nhập vào không tồn tại\n");
    }

    private static void checkYesOrNo(Person x) {
        Scanner scanner= new Scanner(System.in);
        String yesOrNo;
        System.out.println("Hãy xác nhận là bạn muốn xóa.\n" +
                "Yes là đồng ý, No là từ chối.");
        do {
            yesOrNo = scanner.nextLine();
            switch (yesOrNo){
                case "Yes":
                    personList.remove(x);
                    System.out.println("Bạn đã xóa thành công\n");
                    return;
                case "No":
                    System.out.println("Bạn đã hủy xóa!");
                    return;
                default:
                    System.out.println("Chỉ được nhập Yes hoặc No.\n" +
                            "Xin mời nhập lại.");
            }
        }while (true);
    }

    @Override
    public void removeTeacher(String id) {
        for(Person x: personList){
            if (Objects.equals(x.getId(), id)){
                checkYesOrNo(x);
                return;
            }
        }
        System.out.println("Id bạn nhập vào không tồn tại\n");
    }

    @Override
    public void displayStudents() {
        for (Person x: personList){
            if (x instanceof Student){
                System.out.println(x);
            }
        }
        System.out.println();
    }


    @Override
    public void displayTeacher() {
        for (Person x: personList){
            if (x instanceof Teacher){
                System.out.println(x);
            }
        }
        System.out.println();
    }
}
