package Introduction_to_Java.exec;

import java.util.Scanner;

public class Hien_Thi_Loi_Chao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập tên của bạn: ");
        String name = sc.nextLine();
        System.out.println("Hello: " + name);
    }
}
