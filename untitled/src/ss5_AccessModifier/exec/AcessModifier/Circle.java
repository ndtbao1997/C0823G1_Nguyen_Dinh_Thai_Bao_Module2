package ss5_AccessModifier.exec.AcessModifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    Circle(){
    }
    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*this.radius*this.radius;
    }
}
