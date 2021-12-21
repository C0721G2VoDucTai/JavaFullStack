package _11_dsa_stack_queue.exercise.reverse_elements_array_use_stack;

import java.util.Arrays;

import static _11_dsa_stack_queue.exercise.reverse_elements_array_use_stack.Reverse.reverseInterger;
import static _11_dsa_stack_queue.exercise.reverse_elements_array_use_stack.Reverse.reverseString;
public class MainOfReverse {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverseInterger(array);
        System.out.println(Arrays.toString(array));
        String string = "ABCDEF";
        System.out.println(reverseString(string));
    }
}
