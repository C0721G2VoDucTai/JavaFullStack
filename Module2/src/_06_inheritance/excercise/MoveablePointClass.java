package _06_inheritance.excercise;

public class MoveablePointClass extends PointClass {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    MoveablePointClass() {
    }

    public MoveablePointClass(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePointClass(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] arr = {getXSpeed(), getYSpeed()};
        return arr;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePointClass move() { //trả về 1 đối tượng.
       setX(getX()+getXSpeed());
       setY(getY()+getYSpeed());
        return this;
    }

    @Override
    public String toString() {
        return "MoveablePointClass{" +
                "x=" + super.getX() +
                "y=" + super.getY() +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}

