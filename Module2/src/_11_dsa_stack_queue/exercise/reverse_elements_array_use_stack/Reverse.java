package _11_dsa_stack_queue.exercise.reverse_elements_array_use_stack;

import java.util.Arrays;

import java.util.Stack;

public class Reverse {
    public static void reverseInterger(int[] array) {
        Stack< Integer > arrayNumber = new Stack();
        for (int i = 0; i < array.length; i++) {
            arrayNumber.push(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayNumber.pop();
        }
    }
    public static String reverseString(String string) {
        Stack< Character > arrayString = new Stack();
        for (int i = 0; i < string.length(); i++) {
            arrayString.push(string.charAt(i));
        }
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            newString += arrayString.pop();
        }
        return newString;
    }
}
