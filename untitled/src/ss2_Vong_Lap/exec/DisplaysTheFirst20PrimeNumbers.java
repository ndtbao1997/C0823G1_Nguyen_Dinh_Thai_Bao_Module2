package ss2_Vong_Lap.exec;

import java.util.Scanner;

public class DisplaysTheFirst20PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập số lượng số nguyên tố muốn in ra");
        int numbers = Integer.parseInt(sc.nextLine());
        int count = 0;
        int num = 2;
        int i;
        boolean check = true;
        while (count < numbers) {
            i = 2;
            while (i <= Math.sqrt(num)) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.println(num);
                count++;
            }
            num++;
            check = true;
        }
    }
}
