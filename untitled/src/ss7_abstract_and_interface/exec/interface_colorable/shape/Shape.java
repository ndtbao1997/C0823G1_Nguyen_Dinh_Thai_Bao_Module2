package ss7_abstract_and_interface.exec.interface_colorable.shape;

import ss7_abstract_and_interface.exec.interface_colorable.colorable.Colorable;

public abstract class Shape implements Colorable {
    private String color = "blue";
    private boolean filled = true;
    public Shape(){}

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}
