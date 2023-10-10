package ss3_MangVaPhuogthuc.exec;

import java.util.Scanner;

public class CharactersInTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nameStr = "Nguyen Dinh Thai Bao";
        System.out.println("Hãy nhập vào kí tự bạn cần tìm");
        char characters = sc.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < nameStr.length(); i++) {
            if (nameStr.charAt(i) == characters) {
                count++;
            }
        }
        if (count == 0){
            System.out.println("Ký tự không tồn tại");
        } else {
            System.out.println("Số lần xuất hiện là " + count);
        }
    }
}
