package Introduction_to_Java.exec;

import java.util.Scanner;

public class VndToUsd {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số tiền bạn muốn đổi");
        usd = sc.nextDouble();
        double toVnd = usd * vnd;
        System.out.println("Số tiền sau khi quy đổi là: " + toVnd + "VND");
    }
}
