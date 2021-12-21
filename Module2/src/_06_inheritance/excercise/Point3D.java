package _06_inheritance.excercise;

public class Point3D extends Point2D {
    private float z = 0.0f;

    Point3D() {
    }

    Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;

    }

    public float[] getXYZ() {
        float[] array = {super.getX(),super.getY(), getZ() };
        return array;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", x=" + getX() +
                ", y=" + getY() +
                ", y=" + getXYZ()[0] + " " + getXYZ()[1] + " " + getXYZ()[2] +
                '}';
    }
}
