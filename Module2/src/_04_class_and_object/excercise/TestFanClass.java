package _04_class_and_object.excercise;

public class TestFanClass {
    public static void main(String[] args) {
//        BuildingFanClass fan = new BuildingFanClass(BuildingFanClass.FAST,true,5,"Red");
        BuildingFanClass fan1 = new BuildingFanClass();
        fan1.setSpeed(BuildingFanClass.FAST);
        fan1.setOn(true);
        fan1.setColor("Yellow");
        fan1.setRadius(10);
        BuildingFanClass fan2 = new BuildingFanClass();
        fan2.setSpeed(BuildingFanClass.MEDIUM);
        fan2.setOn(false);
        fan2.setColor("Blue");
        fan2.setRadius(5);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
