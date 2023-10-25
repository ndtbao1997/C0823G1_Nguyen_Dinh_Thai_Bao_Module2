package ss13_search_algorithm.exec.ascending_string;

import java.util.*;

public class StringAscending {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập một chuỗi vào.");
        String inputStr = scanner.nextLine();
        String reverseStr = "";
        LinkedList<Character> characterList = new LinkedList<>();
        characterList.add(inputStr.charAt(0));
        for (int i = 1; i < inputStr.length(); i++) {
            if (Character.compare(inputStr.charAt(i),characterList.getLast()) > 0){
                characterList.add(inputStr.charAt(i));
            }
        }
        while (!characterList.isEmpty()){
            reverseStr += characterList.remove();
        }
        System.out.println("Chuỗi tăng dần lớn nhất là:");
        System.out.println(reverseStr);
    }
}
