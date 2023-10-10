package ss2_Vong_Lap.exec;

public class DisplayPrimeNumbersLessThan100 {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++){
            if (checkNum(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean checkNum(int num) {
        int i = 2;
        boolean check = true;
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) {
                check = false;
                break;
            }
            i++;
        }
        return check;
    }
}
