package ss6_inheritance.exec.point2d_and_point3d;

public class Point2D {
    private float x;
    private float y;
    public Point2D(){}
    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){
        setX(x);
        setY(y);
    }
    public float[] getXY(){
        return new float[]{x,y};
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
}
