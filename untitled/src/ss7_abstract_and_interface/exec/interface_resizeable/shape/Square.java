package ss7_abstract_and_interface.exec.interface_resizeable.shape;

public class Square extends Rectangle{
    public Square(){}

    public Square(double side) {
        super(side,side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }
    @Override
    public String toString() {
        return "Square{" +
                "acreage = " + getArea() +
                '}';
    }
}
