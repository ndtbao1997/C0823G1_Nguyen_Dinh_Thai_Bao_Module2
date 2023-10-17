package ss6_inheritance.exec.class_triangle;

public class Tringle extends Shape{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    public Tringle(){}

    public Tringle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public boolean checkSide(){
        if (side1 > 0 && side2 > 0 && side3 > 0 && (side1+side2) > side3 && (side3+side2) > side1 && (side1+side3) > side2){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public double getArea() {
        if (checkSide()){
            double p = getPerimeter()/2;
            return Math.pow((p*(p-side1)*(p-side2)*(p-side3)), 0.5);
        } else {
            return 0;
        }
    }

    @Override
    public double getPerimeter() {
        if (checkSide()){
            return this.side1 + this.side2 + this.side3;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (checkSide()){
            return super.toString() + ", diện tích = " + getArea() + ", chu vi = " + getPerimeter();
        } else {
            return "ba cạnh bạn nhập vào không phải là ba cạnh của tam giác.";
        }

    }
}
