package _02_loop_conditions.practice;

import java.util.Scanner;

public class InterestCalculatedApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double money;
        double interestRate;
        double interestMoney;
        double totalInterest = 0;
        byte month;
        System.out.println("Input money");
        money = input.nextDouble();
        System.out.println("Input interestRate");
        interestRate = input.nextDouble();
        System.out.println("Input month");
        month = input.nextByte();
        interestMoney = (money * interestRate)/12*month;
        System.out.println("Interest money in " + month + " is:" + interestMoney);
    }
}
