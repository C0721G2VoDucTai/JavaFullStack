package calculator.model;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    public String calculation(double numberOne, double numberTwo, char calculation) {
        switch (calculation) {
            case '+':
                return String.valueOf(numberOne + numberTwo);
            case '-':
                return String.valueOf(numberOne - numberTwo);
            case '*':
                return String.valueOf(numberOne * numberTwo);
            case '/':
                if (numberTwo != 0) {
                    return String.valueOf(numberOne + numberTwo);
                } else {
                    return "Can't division by 0";
                }
            default: return "Check your enter data again";
        }
    }
}
