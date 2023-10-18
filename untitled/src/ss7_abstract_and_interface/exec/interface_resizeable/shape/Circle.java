package ss7_abstract_and_interface.exec.interface_resizeable.shape;

public class Circle extends Shape{
    private double radius = 1.0;
    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "acreage = " + getArea() +
                ", acreage after resize = " + resizeShape() +
                '}';
    }
}
