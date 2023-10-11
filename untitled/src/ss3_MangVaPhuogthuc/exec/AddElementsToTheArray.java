package ss3_MangVaPhuogthuc.exec;

import java.util.Scanner;

public class AddElementsToTheArray {
    public static void main(String[] args) {
        int a;
        int[] numArr;
        int newValue;
        int index;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số phần tử của mảng");
        a = Integer.parseInt(sc.nextLine());
        numArr = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.println("Hãy nhập giá trị của phần tử " + (i + 1));
            numArr[i] = sc.nextInt();
        }
        System.out.println("Hãy nhập giá trị cần thêm vào mảng");
        newValue = sc.nextInt();
        System.out.println("Hãy nhập vị trí muốn thêm vào");
        index = sc.nextInt();
        if (numArr[a-1] != 0){
            System.out.println("Mảng đã chứa đầy phần tử! Không thể thêm vào nữa");
        } else {
            if (index >= a || index < 0){
                System.out.println("Bạn không thể thêm vào vị trí thứ " + index);
            } else {
                if (numArr[index] != 0) {
                    for (int j = numArr.length - 1; j > index; j--) {
                        numArr[j] = numArr[j - 1];
                    }
                }
                numArr[index] = newValue;
            }
        }
        for (int k: numArr){
            System.out.println(k);
        }
    }
}
