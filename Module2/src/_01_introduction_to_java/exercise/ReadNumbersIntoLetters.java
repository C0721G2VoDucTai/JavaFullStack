package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class ReadNumbersIntoLetters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        int number0;
        int number1;
        int number2;

        System.out.println("Input intelegi numbers");
        number = input.nextInt();
        if (number > 0 && number < 10)
            switch (number) {
                case 1:
                    System.out.print("one");
                    break;
                case 2:
                    System.out.print("two");
                    break;
                case 3:
                    System.out.print("three");
                    break;
                case 4:
                    System.out.print("four");
                    break;
                case 5:
                    System.out.print("five");
                    break;
                case 6:
                    System.out.print("six");
                    break;
                case 7:
                    System.out.print("seven");
                    break;
                case 8:
                    System.out.print("eight");
                    break;
                case 9:
                    System.out.print("nine");
                    break;
                case 10:
                    System.out.print("ten");
                    break;
            }
        else if (number < 20) {
            switch (number - 10) {
                case 1:
                    System.out.print("eleven");
                    break;
                case 2:
                    System.out.print("twelve");
                    break;
                case 3:
                    System.out.print("thirteen");
                    break;
                case 4:
                    System.out.print("fourteen");
                    break;
                case 5:
                    System.out.print("fifteen");
                    break;
                case 6:
                    System.out.print("sixteen");
                    break;
                case 7:
                    System.out.print("seventeen");
                    break;
                case 8:
                    System.out.print("eightteen");
                    break;
                case 9:
                    System.out.print("nineteen");
                    break;
            }
        } else if (number < 100) {
            number1 = (int) number / 10;
            number2 = number - (number1 * 10);
            switch (number1) {
                case 2:
                    System.out.print("twenty ");
                    break;
                case 3:
                    System.out.print("thirty ");
                    break;
                case 4:
                    System.out.print("fourty ");
                    break;
                case 5:
                    System.out.print("fifty ");
                    break;
                case 6:
                    System.out.print("sixty ");
                    break;
                case 7:
                    System.out.print("seventy ");
                    break;
                case 8:
                    System.out.print("eighty");
                    break;
                case 9:
                    System.out.print("ninety");
                    break;
                default:
            }
            switch (number2) {
                case 1:
                    System.out.print("one");
                    break;
                case 2:
                    System.out.print("two");
                    break;
                case 3:
                    System.out.print("three");
                    break;
                case 4:
                    System.out.print("four");
                    break;
                case 5:
                    System.out.print("five");
                    break;
                case 6:
                    System.out.print("six");
                    break;
                case 7:
                    System.out.print("seven");
                    break;
                case 8:
                    System.out.print("eight");
                    break;
                case 9:
                    System.out.print("nine");
                    break;
            }
        } else {
            number0 = (int) (number / 100);
            number1 = (int) ((number - number0 * 100) / 10);
            number2 = (number - number0 * 100 - number1 * 10);
            switch (number0) {
                case 1:
                    System.out.print("one hundred and ");
                    break;
                case 2:
                    System.out.print("two hundred and ");
                    break;
                case 3:
                    System.out.print("three hundred and ");
                    break;
                case 4:
                    System.out.print("four hundred and ");
                    break;
                case 5:
                    System.out.print("five hundred and ");
                    break;
                case 6:
                    System.out.print("six hundred and ");
                    break;
                case 7:
                    System.out.print("seven hundred and ");
                    break;
                case 8:
                    System.out.print("eight hundred and ");
                    break;
                case 9:
                    System.out.print("nine hundred and ");
                    break;
            }
            if (number1*10 + number2 < 10) {
                switch (number2) {
                    case 1:
                        System.out.print("one");
                        break;
                    case 2:
                        System.out.print("two");
                        break;
                    case 3:
                        System.out.print("three");
                        break;
                    case 4:
                        System.out.print("four");
                        break;
                    case 5:
                        System.out.print("five");
                        break;
                    case 6:
                        System.out.print("six");
                        break;
                    case 7:
                        System.out.print("seven");
                        break;
                    case 8:
                        System.out.print("eight");
                        break;
                    case 9:
                        System.out.print("nine");
                        break;
                }
            }
            else if (number1*10 + number2 < 10){
                switch (number2) {
                    case 1:
                        System.out.print("eleven ");
                        break;
                    case 2:
                        System.out.print("twelfth ");
                        break;
                    case 3:
                        System.out.print("thirteen");
                        break;
                    case 4:
                        System.out.print("fourteen ");
                        break;
                    case 5:
                        System.out.print("fifteen ");
                        break;
                    case 6:
                        System.out.print("sixteen ");
                        break;
                    case 7:
                        System.out.print("seventeen ");
                        break;
                    case 8:
                        System.out.print("eightteen ");
                        break;
                    case 9:
                        System.out.print("nineteen ");
                        break;
                }
            } else {
                switch (number1) {
                    case 2:
                        System.out.println("twenty ");
                        break;
                    case 3:
                        System.out.println("thirty ");
                        break;
                    case 4:
                        System.out.print("fourty ");
                        break;
                    case 5:
                        System.out.print("fifty ");
                        break;
                    case 6:
                        System.out.print("sixty ");
                        break;
                    case 7:
                        System.out.print("seventy ");
                        break;
                    case 8:
                        System.out.print("eighty ");
                        break;
                    case 9:
                        System.out.print("ninety ");
                        break;
                    default:
                }
                switch (number2) {
                    case 1:
                        System.out.print("one");
                        break;
                    case 2:
                        System.out.print("two");
                        break;
                    case 3:
                        System.out.print("three");
                        break;
                    case 4:
                        System.out.print("four");
                        break;
                    case 5:
                        System.out.print("five");
                        break;
                    case 6:
                        System.out.print("six");
                        break;
                    case 7:
                        System.out.print("seven");
                        break;
                    case 8:
                        System.out.print("eight");
                        break;
                    case 9:
                        System.out.print("nine");
                        break;
                }
            }
        }

    }
}
