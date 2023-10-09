package ss1_Introduction_to_Java.exec;

import java.util.Scanner;

public class Ung_Dung_Doc_So_Thanh_Chu {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập một số nguyên không âm");
        number = sc.nextInt();
        String[] s = String.valueOf(number).split("");
        switch (s.length) {
            case 1:
                if (s[0].equals("0")) {
                    System.out.println("Zero");
                } else {
                    System.out.println(unitRow(s[0]));
                }
                break;
            case 2:
                System.out.println(dozens(s[0], unitRow(s[1])));
                break;
            case 3:
                if (s[1].equals("0") && s[2].equals("0")) {
                    System.out.println(hundredUP(s[0]));
                } else {
                    System.out.print(hundredUP(s[0]));
                    System.out.print(" and " + dozens(s[1], unitRow(s[2])));
                }
        }
    }

    private static String unitRow(String number) {
        switch (number){
            case "0":
                return "";
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eigth";
            case "9":
                return "nine";
            default:
                return "out of ability";
        }
    }
    private static String dozens(String a, String b){
        switch (a){
            case "0":
                return b;
            case "1":
                switch (b){
                    case "0":
                        return "ten";
                    case "1":
                        return "eleven";
                    case "2":
                        return "twelve";
                    case "3":
                        return "thirdteen";
                    default:
                        return b + "teen";
                }
            case "2":
                return "tewnty " + b;
            case "3":
                return "thirty " + b;
            default:
                return unitRow(a) + "ty " + b;
        }
    }
    private static String hundredUP(String c){
        return unitRow(c) + " hundred ";
    }

}




