package ss4_LopVaDoiTuongTrongJava.exec;

public class BuildFanClass {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public boolean getOn(){
        return this.on;
    }
    public void setON(boolean on){
        this.on = on;
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public BuildFanClass(){
    }
    public String toString(){
        if (this.on){
            return this.speed + ", " + this.color + ", " + this.radius + ", " + "fan is on";
        } else {
            return this.speed + ", " + this.color + ", " + this.radius + ", " + "fan is off";
        }
    }
}
