package ss6_inheritance.exec.PointAndMoveablePoint;

import java.util.Arrays;

public class TestPointAndMovablePoint {
    public static void main(String[] args) {
        Point point = new Point(3,5);
        System.out.println(point);
        MovablePoint moPoint = new MovablePoint(3,5,7,9);
        System.out.println(moPoint);
        moPoint.move();
        System.out.println(moPoint);
        System.out.println(Arrays.toString(moPoint.getSpeed()));
    }
}
