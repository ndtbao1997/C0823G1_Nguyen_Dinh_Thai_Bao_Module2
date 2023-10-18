package ss7_abstract_and_interface.exec.interface_resizeable.shape;

public class Square extends Shape{
    private double side = 1.0;
    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getPerimeter() {
        return 4*side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "acreage = " + getArea() +
                ", acreage after resize = " + resizeShape() +
                '}';
    }
}
