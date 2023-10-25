package ss13_search_algorithm.exec.use_binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrLength;
        int[] arrInteger;
        int value;
        do {
            System.out.println("Hãy nhập số lượng phần tử của mảng");
            arrLength = Integer.parseInt(scanner.nextLine());
        } while (arrLength < 0);
        arrInteger = new int[arrLength];
        System.out.println("Hãy nhập các giá trị số nguyên cho các phần tử của mảng");
        for (int i = 0; i < arrLength; i++) {
            System.out.println("Giá trị thứ " + (i + 1));
            arrInteger[i] = Integer.parseInt(scanner.nextLine());
        }
        Arrays.sort(arrInteger);
        System.out.println(Arrays.toString(arrInteger) + "\n");
        System.out.println("Hãy nhập giá trị bạn muốn tìm");
        value = Integer.parseInt(scanner.nextLine());
        binarySearch(arrInteger, 0, arrInteger.length - 1, value);
    }

    private static void binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;
        if (left > right) {
            System.out.println("Giá trị bạn tìm không tồn tại trong mảng bạn vừa nhập");
            return;
        }
        if (array[middle] == value) {
            System.out.println("Giá trị bạn tìm nằm ở vị trí " + middle);
            return;
        } else if (value > array[middle]) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
        binarySearch(array, left, right, value);
    }
}
