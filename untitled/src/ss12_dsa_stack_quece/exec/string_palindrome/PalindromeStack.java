package ss12_dsa_stack_quece.exec.string_palindrome;

import java.util.Scanner;
import java.util.Stack;

public class PalindromeStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập vào một chuỗi bạn muốn kiểm tra");
        String str = scanner.nextLine();
        String reverseStr = "";
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stringStack.push(String.valueOf(str.charAt(i)));
        }
        while (!stringStack.isEmpty()){
            reverseStr += stringStack.pop();
        }
        if (reverseStr.equals(str)){
            System.out.println("Chuỗi này là chuỗi Palindrome");
        } else {
            System.out.println("Chuỗi này không phải chuỗi Palindrome");
        }
    }
}
