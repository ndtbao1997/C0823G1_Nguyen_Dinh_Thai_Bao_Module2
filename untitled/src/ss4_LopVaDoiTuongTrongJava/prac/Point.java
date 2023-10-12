package ss4_LopVaDoiTuongTrongJava.prac;

public class Point {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int k = 5; k >= i; k--) {
                System.out.print("+");
            }
            for (int j = 1; j <= 2*i; j++) {
                if (j == 1 || j == 2*i ){
                    System.out.print(i);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");

        }
    }

}
