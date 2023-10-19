package ss7_abstract_and_interface.exec.interface_colorable.shape;

import ss7_abstract_and_interface.exec.interface_colorable.colorable.Colorable;

public class Square extends Rectangle implements Colorable {
    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    @Override
    public String howToColor() {
        return "Color all four sides..";
    }

    @Override
    public String toString() {
        return "Square{" +
                "acreage = " + getArea() +
                ", " + howToColor() +
                '}';
    }
}
