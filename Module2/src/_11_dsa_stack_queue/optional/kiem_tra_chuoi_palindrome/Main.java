package _11_dsa_stack_queue.optional.kiem_tra_chuoi_palindrome;

import static _11_dsa_stack_queue.optional.kiem_tra_chuoi_palindrome.CheckPalindrome.checkPalindrome;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("abba"));
        System.out.println(checkPalindrome("Able was I ere I saw Elba"));
        System.out.println(checkPalindrome("abdcefa"));
    }
}

