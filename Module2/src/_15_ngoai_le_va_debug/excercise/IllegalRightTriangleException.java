package _15_ngoai_le_va_debug.excercise;

public class IllegalRightTriangleException extends Exception {
    public IllegalRightTriangleException() {
    }
    public IllegalRightTriangleException(String errorInputSide) {
        super(errorInputSide);
    }
}
