package ss12_dsa_stack_quece.exec.reverse_array;

import java.util.Arrays;
import java.util.Stack;

public class MyArrayStack {
    public static void main(String[] args) {
        System.out.println("Đảo ngược các phần tử mảng số nguyên");
        Integer[] arrayInteger = new Integer[]{2,3,4,5,6,7};
        System.out.println(Arrays.toString(arrayInteger));
        Stack<Integer> stackInteger = new Stack<>();
        for (int i = 0; i < arrayInteger.length; i++) {
            stackInteger.push(arrayInteger[i]);
            arrayInteger[i]= null;
        }
        int stackSize = stackInteger.size();
        for (int k = 0; k < stackSize; k++) {
            arrayInteger[k] = stackInteger.peek();
            stackInteger.pop();
        }
        System.out.println("Mảng sau khi đảo ngược là");
        System.out.println(Arrays.toString(arrayInteger) + "\n");
        System.out.println("Đảo ngược chuỗi sử dụng stack");
        Stack<String> wStack = new Stack<>();
        String word = "Reverse elements in an integer array using Stack";
        String[] mWord = word.split(" ");
        System.out.println(word);
        for (String c : mWord) {
            wStack.push(c);
        }
        int sizeWStack = wStack.size();
        System.out.println("Chuỗi sau khi đảo ngược là:");
        for (int m = 0; m < sizeWStack; m++) {
            System.out.printf("%s ", wStack.pop());
        }
    }
}
