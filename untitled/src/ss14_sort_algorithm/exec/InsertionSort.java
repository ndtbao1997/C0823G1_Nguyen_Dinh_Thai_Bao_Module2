package ss14_sort_algorithm.exec;

import java.util.Arrays;

public class InsertionSort {
    static int[] list = new int[]{2, 3, -1, 9, 6, 10, 5};

    public static void main(String[] args) {
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void insertionSort(int[] list) {
        int pos;
        int x;
        for (int i = 0; i < list.length; i++) {
            x = list[i];
            pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
        }
    }
}
