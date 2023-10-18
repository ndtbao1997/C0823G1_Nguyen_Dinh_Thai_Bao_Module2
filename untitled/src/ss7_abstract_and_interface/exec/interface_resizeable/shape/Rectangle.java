package ss7_abstract_and_interface.exec.interface_resizeable.shape;

public class Rectangle extends Shape{
    private double width = 1.0;
    private double height = 1.0;
    public Rectangle(){}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "acreage = " + getArea() +
                ", acreage after resize = " + resizeShape() +
                '}';
    }
}
