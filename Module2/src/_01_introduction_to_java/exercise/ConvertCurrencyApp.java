package _01_introduction_to_java.exercise;
import java.util.Scanner;

public class ConvertCurrencyApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float rate = 23000.0f;
        float vnd;
        float usd;
        System.out.print("Input the number of money you want to convert:");
        usd = input.nextFloat();
        vnd = rate * usd;
        System.out.print("The money VND after convert is:" + vnd);



    }
}
