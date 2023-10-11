package ss4_LopVaDoiTuongTrongJava.exec;

import static ss4_LopVaDoiTuongTrongJava.exec.BuildFanClass.FAST;
import static ss4_LopVaDoiTuongTrongJava.exec.BuildFanClass.MEDIUM;

public class Main1 {
    public static void main(String[] args) {
        BuildFanClass fan1 = new BuildFanClass();
        fan1.setON(true);
        fan1.setSpeed(FAST);
        fan1.setColor("yellow");
        fan1.setRadius(10);
        System.out.println(fan1.toString());
        BuildFanClass fan2 = new BuildFanClass();
        fan2.setON(false);
        fan2.setSpeed(MEDIUM);
        fan2.setColor("blue");
        fan2.setRadius(5);
        System.out.println(fan2.toString());
        BuildFanClass fan3 = new BuildFanClass();
        System.out.println(fan3.toString());
    }
}
