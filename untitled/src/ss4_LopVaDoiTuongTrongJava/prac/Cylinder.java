package ss4_LopVaDoiTuongTrongJava.prac;

public class Cylinder extends Circle {
    private int height;
    public Cylinder(int radius, int height) {
        super(radius);
        this.height = height;
    }
    @Override
    public double getArea(){
        return super.getArea()*2 + super.getPerimeter()*this.height;
    }
    public double getVolume(){
        return super.getArea()*this.height;
    }
}
