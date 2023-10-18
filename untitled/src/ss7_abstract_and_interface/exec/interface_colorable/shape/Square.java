package ss7_abstract_and_interface.exec.interface_colorable.shape;

public class Square extends Shape{
    private double side;
    public Square(){}
    public Square(double side){
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
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
    public String howToColor(){
        return "Color all four sides..";
    }

    @Override
    public String toString() {
        if (isFilled()){
            return "Square{" +
                    "side=" + side +
                    ", acreage=" + getArea() +
                    ", " + howToColor() +
                    '}';
        } else {
            return "Square{" +
                    "side=" + side +
                    ", acreage=" + getArea() +
                    '}';
        }

    }
}
