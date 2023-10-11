package ss4_LopVaDoiTuongTrongJava.exec;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double experience1;
        double experience2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập giá trị của số thứ nhất");
        double num1 = sc.nextDouble();
        System.out.println("Hãy nhập giá trị của số thứ hai");
        double num2 = sc.nextDouble();
        System.out.println("Hãy nhập giá trị của số thứ ba");
        double num3 = sc.nextDouble();
        QuadraticEquation equation1 = new QuadraticEquation(num1, num2, num3);
        double delta = equation1.getDiscriminant();
        if (delta > 0) {
            experience1 = equation1.getRoot1();
            experience2 = equation1.getRoot2();
            System.out.println("Phương trình có hai nghiệm là " + experience1 + " và " + experience2);
        } else if (delta == 0) {
            experience1 = equation1.getRoot1();
            System.out.println("Phương trình có nghiệm duy nhất là " + experience1);
        } else {
            System.out.println("Phương trình không có nghiệm");
        }
    }
}
