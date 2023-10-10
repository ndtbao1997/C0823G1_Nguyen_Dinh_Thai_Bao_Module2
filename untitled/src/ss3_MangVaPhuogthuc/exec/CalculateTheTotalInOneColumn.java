package ss3_MangVaPhuogthuc.exec;

import java.util.Scanner;

public class CalculateTheTotalInOneColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số phần tử của mảng cha");
        int row = sc.nextInt();
        System.out.println("Hãy nhập số phần tử của mảng con");
        int col = sc.nextInt();
        double[][] realNumArr = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Hãy nhập phần tử " + i + " " + j);
                realNumArr[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Hãy nhập vào cột mà bạn muốn tính tổng");
        int totalOfRow = sc.nextInt();
        if (totalOfRow > realNumArr.length-1){
            System.out.println("Cột này không tồn tại");
        } else {
            double total = 0;
            for (int k = 0; k < realNumArr[totalOfRow].length; k++){
                total += realNumArr[totalOfRow][k];
            }
            System.out.println("Tổng của cột " + totalOfRow + " là " + total);
        }
    }
}
