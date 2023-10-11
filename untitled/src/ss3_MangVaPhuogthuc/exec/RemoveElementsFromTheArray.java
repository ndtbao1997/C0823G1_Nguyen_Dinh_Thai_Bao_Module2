package ss3_MangVaPhuogthuc.exec;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementsFromTheArray {
    public static void main(String[] args) {
        int n;
        int numToSearch;
        int index;
        int[] numArr;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số lượng phần tử của mảng");
        n = sc.nextInt();
        numArr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Hãy nhập giá trị của phần tử " + (i + 1));
            numArr[i] = sc.nextInt();
        }
        System.out.println("Hãy nhập giá trị bạn cần xóa");
        numToSearch = sc.nextInt();
        index = Arrays.binarySearch(numArr, numToSearch);
        if (index < 0) {
            System.out.println("Phần tử không tìm thấy trong mảng");
        } else {
            if (index != numArr[numArr.length - 1]) {
                for (int j = index; j < numArr.length - 1; j++) {
                    numArr[j] = numArr[j + 1];
                }
            }
            numArr[numArr.length-1] = 0;
        }
        for (int k : numArr) {
            System.out.println(k);
        }
    }
}
