package ss6_inheritance.exec.class_triangle;

import java.util.Scanner;

public class TestTringle {
    public static void main(String[] args) {
        String color;
        double s1;
        double s2;
        double s3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập vào màu sắc của tam giác");
        color = sc.nextLine();
        System.out.println("Hãy nhập độ dài cạnh thứ nhất");
        s1 = sc.nextDouble();
        System.out.println("Hãy nhập độ dài cạnh thứ hai");
        s2 = sc.nextDouble();
        System.out.println("Hãy nhập độ dài cạnh thứ ba");
        s3 = sc.nextDouble();
        Tringle tringle = new Tringle(color, s1, s2, s3);
        System.out.println(tringle);
    }
}
