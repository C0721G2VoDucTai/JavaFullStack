package _06_inheritance.excercise;

public class PointClass {
    private float x = 00.f;
    private float y = 0.0f;

    PointClass() {
    }

    PointClass(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] array = {getX(), getY()};
        return array;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "PointClass{" +
                "x=" + x +
                ", y=" + y +
                ", xy=" + getXY()[0] + " " + getXY()[1] +
                '}';
    }
}
