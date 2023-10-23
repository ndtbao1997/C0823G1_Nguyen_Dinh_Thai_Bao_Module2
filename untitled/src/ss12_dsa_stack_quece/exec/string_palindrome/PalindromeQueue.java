package ss12_dsa_stack_quece.exec.string_palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập một chuỗi bạn muốn kiểm tra.");
        String str = scanner.nextLine();
        Queue<String> stringQueue = new LinkedList<>();
        String reverseStr = "";
        for (int i = str.length()-1; i >= 0; i--) {
            stringQueue.add(String.valueOf(str.charAt(i)));
        }
        while (!stringQueue.isEmpty()){
            reverseStr += stringQueue.remove();
        }
        if (reverseStr.equals(str)){
            System.out.println("Chuỗi này là chuỗi Palindrome");
        } else {
            System.out.println("Chuỗi này không phải chuỗi Palindrome");
        }
    }
}
