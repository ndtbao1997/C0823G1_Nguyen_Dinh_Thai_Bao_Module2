package ss3_MangVaPhuogthuc.exec;

import java.util.Scanner;

public class SquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số phần tử của ma trận vuông");
        int a = sc.nextInt();
        double[][] matrixArr = new double[a][a];
        double total = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.println("Hãy nhập giá trị ở phần tử " + i + " " + j);
                matrixArr[i][j] = sc.nextDouble();
                if (i == j){
                    total += matrixArr[i][j];
                }
            }
        }
        System.out.println("Tổng đường chéo chính là " + total);
    }
}
