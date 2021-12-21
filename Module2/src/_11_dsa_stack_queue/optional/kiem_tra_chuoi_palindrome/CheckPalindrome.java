package _11_dsa_stack_queue.optional.kiem_tra_chuoi_palindrome;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
public class CheckPalindrome {
    public static boolean checkPalindrome(String str) {
        String[] strArray = str.toLowerCase().split("");
        System.out.println(Arrays.toString(strArray));
        Stack< String > stack = new Stack<>();
        Queue< String > queue = new ArrayDeque<>();
        for (int i = 0; i < strArray.length; i++) {
            stack.push(strArray[i]);
            queue.add(strArray[i]);
        }
        while (!stack.isEmpty()) {
            if (!(stack.pop().equals(queue.poll()))) {
                return false;
            }
        }
        return true;
    }
}
