package ss10_dsa.exec;

import java.util.Arrays;

public class TestMyList {
    public static void main(String[] args) {
        MyList<Integer> numberList = new MyList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(3,5);
        numberList.add(3,3);
        for (int i = 0; i < numberList.size(); i++) {
            System.out.println(numberList.get(i));
        }
        System.out.println(numberList.contains(5));

        System.out.println(numberList.indexOf(3));
        MyList<Integer> numberList1;
        numberList1 = numberList.clone();
        numberList1.add(9);
    }
}
