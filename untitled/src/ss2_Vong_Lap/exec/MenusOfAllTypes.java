package ss2_Vong_Lap.exec;

import java.util.Scanner;

public class MenusOfAllTypes {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3.Print isosceles triangle");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Nhập chiều cao a");
                    a = sc.nextInt();
                    System.out.println("Nhập chiều rộng b");
                    b = sc.nextInt();
                    for (int i = 1; i <= a; i++){
                        for (int j = 1; j <= b; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Nhập chiều cao của tam giác");
                    a = sc.nextInt();
                    for (int i = 1; i <= a; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("Hãy nhập chiều cao của hình tam giác");
                    a = sc.nextInt();
                    for (int i = 1; i <= a; i++) {
                        for (int k = a; k > i; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= 2*i -1; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice");
            }
        }
    }
}
