package ss12_dsa_stack_quece.exec.check_bracket;

import java.util.Stack;

public class BracketStack {
    public static void main(String[] args) {
        String str = "s * ((s – a) * (s – b) * (s – c) ";
        if(checkBracket(str)){
            System.out.println("Dấu ngoặc trong biểu thức được sắp xếp đúng");
        } else {
            System.out.println("Dấu ngoặc trong biểu thức sắp xếp không đúng");
        }
    }

    private static boolean checkBracket(String str) {
        String sym = "";
        String left = "";
        boolean checkBracket = true;
        Stack<String> bracketStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals("(")){
                bracketStack.push(String.valueOf(str.charAt(i)));
            } else if (String.valueOf(str.charAt(i)).equals(")")) {
                if (bracketStack.isEmpty()){
                    checkBracket = false;
                    break;
                } else {
                    sym += str.charAt(i);
                }
            }
        }
        while (!bracketStack.isEmpty()){
            left += bracketStack.pop();
        }
        if (left.length() != sym.length()){
            checkBracket = false;
        }
        return checkBracket;
    }
}
