package _04_class_and_object.excercise;
public class BuildingFanClass {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public BuildingFanClass(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() { //getter ko có tham số truyền vào, có giá trị trả về
        return this.speed;  // setter có tham số truyền vào, ko có giá trị trả về.
    }

    public boolean isOn() {
        return this.on;
    }

    public double getRadius() {
        return this.radius = 5.0;
    }

    public String getColor() {
        return this.color = "blue";
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    BuildingFanClass() {

    }
    public String toString() {
        if (this.on) {
            return "Fan is on " + "speed is: " + this.speed + " color is: " + this.color + " radius is: " + this.radius;
        } else {
            return "Fan is off " + "speed is: " + this.speed + " color is: " + this.color + " radius is: " + this.radius;
        }

    }

//    public static void main(String[] args) {
//        BuildingFanClass fan1 = new BuildingFanClass();
//        fan1.setSpeed(BuildingFanClass.FAST);
//        fan1.setOn(true);
//        fan1.setColor("Yellow");
//        fan1.setRadius(10);
//        BuildingFanClass fan2 = new BuildingFanClass();
//        fan2.setSpeed(BuildingFanClass.MEDIUM);
//        fan2.setOn(false);
//        fan2.setColor("Blue");
//        fan2.setRadius(5);
//        System.out.println(fan1.toString());
//        System.out.println(fan2.toString());
//    }

}
