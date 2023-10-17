package ss6_inheritance.exec.circle_and_cylinder;

public class Cylinder extends Circle{
    private double height;
    public Cylinder(){
    }
    public Cylinder(double height){
        this.height = height;
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }



    @Override
    public double getAcreage() {
        return super.getAcreage()*2 + super.getPerimeter()*this.height;
    }

    public double getVolume(){
        return super.getAcreage()*this.height;
    }

    @Override
    public String toString() {
        return super.toString() + ", height=" + height +
                ", volume=" + getVolume();
    }
}
