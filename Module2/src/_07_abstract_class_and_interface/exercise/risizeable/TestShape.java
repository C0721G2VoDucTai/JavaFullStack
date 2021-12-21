package _07_abstract_class_and_interface.exercise.risizeable;

import sun.awt.geom.AreaOp;

public class TestShape {
    public static void main(String[] args) {
        Shape shape1 = new Circle(10); // ép kiểu ngầm định shape1 có kiểu dữ liệu tham chiếu
        Shape shape2 = new Square(10);
        Shape shape3 = new Rectangle(10, 20);
        Shape[] shapeList = {shape1, shape2, shape3};
        // Có thể dùng interface cho lớp Shape và sử dụng cơ chế Dynamic Byding để gọi resize lớp con mà ko cần ép kiểu;
        for (int i = 0; i < shapeList.length; i++) {
            if (shapeList[i] instanceof Circle) {
                System.out.println("Current Area is:" + ((Circle) shapeList[i]).getArea());
                ((Circle) shapeList[i]).resize((double) Math.random() * 100);
                System.out.println("Area after resize is:" + ((Circle) shapeList[i]).getArea());
            } else if (shapeList[i] instanceof Square) {
                System.out.println("Area is:" + ((Square) shapeList[i]).getArea());
                ((Square) shapeList[i]).resize((double) Math.random() * 100);
                System.out.println("Area after resize is:" + ((Square) shapeList[i]).getArea());
            } else {
                System.out.println("Area is:" + ((Rectangle) shapeList[i]).getArea());
                ((Rectangle) shapeList[i]).resize((double) Math.random() * 100);
                System.out.println("Area after resize is:" + ((Rectangle) shapeList[i]).getArea());
            }
        }

    }
}
