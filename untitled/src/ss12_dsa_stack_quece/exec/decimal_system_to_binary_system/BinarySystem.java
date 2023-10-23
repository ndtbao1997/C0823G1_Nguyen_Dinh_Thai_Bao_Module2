package ss12_dsa_stack_quece.exec.decimal_system_to_binary_system;

import java.util.Scanner;
import java.util.Stack;

public class BinarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer>  binaryStack = new Stack<>();
        System.out.println("Hãy nhập một số nguyên dương bạn muốn");
        int num = Integer.parseInt(scanner.nextLine());
        int newNum;
        while (num != 1){
            binaryStack.push(num%2);
            newNum = (int) (num/2);
            num = newNum;
        }
        binaryStack.push(num%2);
        int sizeStack = binaryStack.size();
        System.out.println("Hệ nhị phân có kết quả là");
        for (int i = 0; i < sizeStack; i++) {
            System.out.printf("%d", binaryStack.pop());
        }
    }
}
