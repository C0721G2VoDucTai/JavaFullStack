package _11_dsa_stack_queue.optional.kiem_tra_dau_ngoac;

public class CheckSymTest {
    public static void main(String[] args) {
        CheckSym checkSym = new CheckSym();
        System.out.println(checkSym.checkSymbol("s * (s – a) * (s – b) * (s – c)"));
        System.out.println(checkSym.checkSymbol("s *  – a) * (s – b) * (s – c)"));
        System.out.println(checkSym.checkSymbol("s * (s – a) * (s – b * (s – c)"));
        System.out.println(checkSym.checkSymbol("(– b + (b^2 – 4*a*c)^(0.5/ 2*a))"));

    }
}
