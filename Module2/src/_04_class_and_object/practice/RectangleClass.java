package _04_class_and_object.practice;
import java.util.Scanner;

public class RectangleClass {
    double width, height;
    public RectangleClass() {
    }
    public RectangleClass(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
       return  this.width * this.height;
    }
    public double getPerimeter() {
        return  (this.width + this.height)*2;
    }
    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double width, height;
        System.out.println("Enter width");
        width = input.nextDouble();
        System.out.println("Enter height");
        height = input.nextDouble();
        RectangleClass rectangle  = new RectangleClass(width, height);
        System.out.println("Rectangle area is: "+ rectangle.getArea());
        System.out.println("Rectangle perimeter is: "+ rectangle.getPerimeter());
    }
}
