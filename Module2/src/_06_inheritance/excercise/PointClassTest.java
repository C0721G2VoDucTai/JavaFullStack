package _06_inheritance.excercise;

import java.util.Arrays;

public class PointClassTest {
    public static void main(String[] args) {
        PointClass pointClass = new PointClass(1, 2);
        System.out.println(pointClass.toString());
        MoveablePointClass move = new MoveablePointClass(2, 3,5, 5);
        move.setXY(2, 3);
        System.out.println(move.getXY()[0] + " " + move.getXY()[1]);
        System.out.println(move.getSpeed()[0] + " " + move.getSpeed()[1]);
        System.out.println(move.move());
        System.out.println(move.toString()); // giống gọi move.move() vì đều trả về mô tả Object
    }
}
