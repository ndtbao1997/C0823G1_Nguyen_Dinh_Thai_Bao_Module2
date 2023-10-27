package ss15_exception.exec;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        try {
            inputSidesTriangle();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inputSidesTriangle() throws Exception {
        int a;
        int b;
        int c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập độ dài cạnh a");
        a = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập độ dài cạnh b");
        b = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập độ dài cạnh c");
        c = Integer.parseInt(scanner.nextLine());
        displaySidesTriangle(a, b, c);
    }

    public static void displaySidesTriangle(int a, int b, int c) throws Exception {
        boolean checkSide = (a < 1) || (b < 1) || (c < 1);
        boolean checkSides = (a + b <= c) || (a + c <= b) || (c + b <= a);
        if (checkSide) throw new IllegalTriangleException("Độ dài cạnh tam giác nhỏ hơn 1");
        if (checkSides) throw new IllegalTriangleException("Độ dài ba cạnh bạn không chính xác");
        System.out.println("Độ dài 3 cạnh của tam giác là : " + a + ", " + b + ", " + c);
    }
}
