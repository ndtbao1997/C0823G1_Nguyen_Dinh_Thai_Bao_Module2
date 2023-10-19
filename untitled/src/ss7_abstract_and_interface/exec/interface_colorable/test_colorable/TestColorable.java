package ss7_abstract_and_interface.exec.interface_colorable.test_colorable;

import ss7_abstract_and_interface.exec.interface_colorable.shape.Rectangle;
import ss7_abstract_and_interface.exec.interface_colorable.shape.Shape;
import ss7_abstract_and_interface.exec.interface_colorable.shape.Square;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Square("Red",true,3);
        shapes[1] = new Square("Black",true,4);
        shapes[2] = new Square("Yellow",false,5);
        shapes[3] = new Rectangle("White",true,5,3);
        for (Shape shape: shapes){
            System.out.println(shape);
        }
    }
}
