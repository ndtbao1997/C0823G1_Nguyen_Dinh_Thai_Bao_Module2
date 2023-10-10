package ss3_MangVaPhuogthuc.exec;

import java.util.Scanner;

public class FindTheLargestElementInATwoDimensionalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số phần tử của mảng cha");
        int row = sc.nextInt();
        System.out.println("Hãy nhập số phần tử của mảng con");
        int col = sc.nextInt();
        double[][] realNumArr = new double[row][col];
        double max = realNumArr[0][0];
        int rowOfMax = 0;
        int colOfMax = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col ; j++) {
                System.out.println("Hãy nhập trị của phần tử " + i + " " + j);
                realNumArr[i][j] = sc.nextDouble();
                if (realNumArr[i][j] > max){
                    max =realNumArr[i][j];
                    rowOfMax = i;
                    colOfMax = j;
                }
            }
        }
        System.out.println("Giá trị lớn nhất là : " + max);
        System.out.println("Vị trí : " + "i " + rowOfMax + ", j " + colOfMax);
    }
}
