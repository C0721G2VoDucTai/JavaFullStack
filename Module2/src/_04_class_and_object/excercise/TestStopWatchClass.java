package _04_class_and_object.excercise;

import java.lang.Math;
import java.util.Arrays;

public class TestStopWatchClass {
    public static void main(String[] args) {
        BuildingStopWatch watch = new BuildingStopWatch();
        watch.start();
        int array[] = new int[100000];
//        System.out.println("Creat array");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.floor((Math.random() * 100000));
        }
//        System.out.println("Display array");
//        System.out.println(Arrays.toString(array));
        for (int i = 0; i < 100000; i++) {
            for (int j = i + 1; j < 100000; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
//        System.out.println("Display Array after sorted");
//        System.out.println(Arrays.toString(array));
        watch.stop();
        System.out.println("ElapsedTime: " + watch.getElapsedTime());
    }
}
