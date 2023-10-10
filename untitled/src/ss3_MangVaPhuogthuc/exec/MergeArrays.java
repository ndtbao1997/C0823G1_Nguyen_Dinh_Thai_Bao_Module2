package ss3_MangVaPhuogthuc.exec;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập vào số lượng phần tử của mảng thứ nhất");
        int a = sc.nextInt();
        int[] numArrA = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.println("Hãy nhập vào giá trị " + (i+1) + " của mảng thứ nhất");
            numArrA[i] = sc.nextInt();
        }
        System.out.println("Hãy nhập vào số lượng phần tử của mảng thứ hai");
        int b = sc.nextInt();
        int[] numArrB = new int[b];
        for (int j = 0; j < b; j++) {
            System.out.println("Hãy nhập vào giá trị " + (j+1) + " của mảng thứ hai");
            numArrB[j] = sc.nextInt();
        }
        int[] numArrC = new int[a+b];
        System.arraycopy(numArrA, 0, numArrC, 0, numArrA.length);
        System.arraycopy(numArrB, 0, numArrC, numArrA.length, numArrB.length);
        System.out.println(Arrays.toString(numArrC));
    }
}
