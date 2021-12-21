package _06_inheritance.excercise;

public class Point2D3DTest {
    public static void main(String[] args) {

        System.out.println("Test Point2D:");
        Point2D point2D = new Point2D(3.0f, 5.0f);
        System.out.println(point2D.toString());
        point2D.setXY(4, 8);
        System.out.println(point2D.toString());
        System.out.println("Test Point3D:");
        Point3D point3D = new Point3D(2.0f, 3.0f, 4.0f);
        System.out.println(point3D.toString());
        point3D.setXYZ(4, 5, 6);
        System.out.println(point3D.toString());

    }
}
