package _11_dsa_stack_queue.optional.chuyen_doi_thap_phan_sang_nhi_phan;

import java.util.Stack;

public class Convert {
    public String convert(int n) {
        Stack< Integer > stack = new Stack<>();
        String string = "";
        while (n > 0) {
            int a = n % 2;
            stack.push(a);
            n = n / 2;
        }
        while (!stack.isEmpty()){
            string += stack.peek();
            stack.pop();
        }
        return string;
    }
}
