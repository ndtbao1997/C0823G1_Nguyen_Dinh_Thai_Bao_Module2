package ss6_inheritance.exec.class_triangle;

public abstract class Shape {
    private String color;
    public Shape(){}

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "color=" + color;
    }
}
