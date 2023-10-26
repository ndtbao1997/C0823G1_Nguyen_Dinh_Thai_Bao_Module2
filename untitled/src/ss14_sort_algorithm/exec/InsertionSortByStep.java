package ss14_sort_algorithm.exec;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập số lượng phần tử");
        int arrLength = Integer.parseInt(scanner.nextLine());
        int[] arrInteger = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            System.out.println("Hãy nhập giá trị ở vị trí " + (i+1));
            arrInteger[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Các bước sắp xếp bằng thuật toán Insertion Sort:");
        insertionSortByStep(arrInteger);
    }

    public static void insertionSortByStep(int[] arr) {
        int pos;
        int x;
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            pos = i;
            System.out.println("Giá trị được chọn " + x + " nằm ở vị trí " + pos);
            while (pos > 0 && x < arr[pos - 1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
            System.out.println("Giá trị được chọn " + x + " vị trí sau khi thay đổi " + pos);
            System.out.println("Step " + (i + 1) + " result: " + Arrays.toString(arr) + "\n");
        }
    }
}
