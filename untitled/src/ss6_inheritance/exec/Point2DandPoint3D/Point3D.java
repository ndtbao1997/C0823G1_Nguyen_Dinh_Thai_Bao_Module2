package ss6_inheritance.exec.Point2DandPoint3D;

public class Point3D extends Point2D{
    private float z;
    Point3D(){}
    Point3D(float z){
        this.z = z;
    }
    Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        super.setXY(x, y);
        setZ(z);
    }
    public float[] getXYZ(){
        return new float[]{getX(),getY(),z};
    }

    @Override
    public String toString() {
        return super.toString() + ", " + z;
    }
}
