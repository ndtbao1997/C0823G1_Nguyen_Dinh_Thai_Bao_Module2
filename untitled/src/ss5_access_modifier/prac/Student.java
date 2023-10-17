package ss5_access_modifier.prac;

public class Student {
    int rollno;
    String name;
    static String college = "BachKhoa";

    static void method() {
        college = "QuocGia";
    }

    Student(int r, String n) {
        rollno = r;
        name = n;
    }

    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }

    public static void main(String args[]) {
        Student.college = "aa";
        Student.method();
        System.out.println(Student.college);


    }
}
