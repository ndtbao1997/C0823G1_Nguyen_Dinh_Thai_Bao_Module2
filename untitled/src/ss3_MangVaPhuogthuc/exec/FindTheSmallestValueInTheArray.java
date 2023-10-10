package ss3_MangVaPhuogthuc.exec;

import java.util.Scanner;

public class FindTheSmallestValueInTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        do {
            System.out.println("Hãy nhập số phần tử của mảng");
            a = sc.nextInt();
        } while (a < 1);
        int[] numArr = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.println("Hãy nhập giá trị ở vị trí " + (i + 1));
            numArr[i] = sc.nextInt();
        }
        int min = numArr[0];
        for (int j = 1; j < a; j++) {
            if (numArr[j] < min) {
                min = numArr[j];
            }
        }
        System.out.println("Giá trị nhỏ nhất là: " + min);
    }
}
