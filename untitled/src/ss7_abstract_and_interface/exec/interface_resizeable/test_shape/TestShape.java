package ss7_abstract_and_interface.exec.interface_resizeable.test_shape;

import ss7_abstract_and_interface.exec.interface_resizeable.shape.Circle;
import ss7_abstract_and_interface.exec.interface_resizeable.shape.Rectangle;
import ss7_abstract_and_interface.exec.interface_resizeable.shape.Shape;
import ss7_abstract_and_interface.exec.interface_resizeable.shape.Square;

public class TestShape {
    public static void main(String[] args) {
        double percent;
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(4,5);
        shapes[2] = new Square(6);
        percent = Math.random();
        for (Shape shape: shapes){
            shape.resize(percent);
            System.out.println(shape);
        }
    }
}
