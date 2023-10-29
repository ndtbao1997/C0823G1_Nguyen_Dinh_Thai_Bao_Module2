package ss15_exception.exec;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        try {
            inputSidesTriangle();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void inputSidesTriangle() throws Exception {
        double side1;
        double side2;
        double side3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập độ dài cạnh thứ nhất");
        side1 = Double.parseDouble(scanner.nextLine());
        if (side1 <= 0) {
            throw new IllegalTriangleException("Độ dài không hợp lệ");
        }
        System.out.println("Hãy nhập độ dài cạnh thứ hai");
        side2 = Double.parseDouble(scanner.nextLine());
        if (side2 <= 0) {
            throw new IllegalTriangleException("Độ dài không hợp lệ");
        }
        System.out.println("Hãy nhập độ dài cạnh thứ ba");
        side3 = Double.parseDouble(scanner.nextLine());
        if (side3 <= 0) {
            throw new IllegalTriangleException("Độ dài không hợp lệ");
        }
        displaySidesTriangle(side1, side2, side3);
    }

    public static void displaySidesTriangle(double a, double b, double c) throws Exception {
        boolean checkSides = (a + b > c) && (a + c > b) && (c + b > a);
        if (!checkSides) {
            throw new IllegalTriangleException("Độ dài ba cạnh bạn không chính xác");
        }
        System.out.println("Độ dài 3 cạnh của tam giác là : " + a + ", " + b + ", " + c);
    }
}
