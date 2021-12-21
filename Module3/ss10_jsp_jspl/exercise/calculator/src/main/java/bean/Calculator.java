package bean;

public class Calculator {
    public static Double calculator (Double firstOperator, Double secondOperator, char operator){
        Double result;
        switch (operator) {
            case '+':
                result = firstOperator + secondOperator;
                break;
            case '-':
                result = firstOperator - secondOperator;
                break;
            case '*':
                result = firstOperator * secondOperator;
                break;
            case '/':
                if(secondOperator !=0) {
                    result = firstOperator / secondOperator;
                }
                else {
                    throw new ArithmeticException("Can't divide by 0");
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;

    }
}
