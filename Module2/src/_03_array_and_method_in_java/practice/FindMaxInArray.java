package _03_array_and_method_in_java.practice;

import java.util.Scanner;

public class FindMaxInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] assets;
        int number;
        do {
            System.out.println("Enter number of Billionaire you want compare");
            number = input.nextInt();
            if (number < 0 || number > 20) {
                System.out.println("Enter number of Billionaire again");
            }
        } while (number > 20);
        assets = new double[20];
        for (int i = 0; i < number; i++) {
            System.out.printf("Enter number of assets of Billionaire (Unit is billion USD): ", (i + 1), "\t");
            assets[i] = input.nextDouble();
        }
        System.out.printf("%-20s%s", "List of assets: ", "");
        for (int i = 0; i < assets.length; i++) {
            System.out.print(assets[i] + "\t"); // /"\t" để chèn 1 khoảng trắng
        }
        double max = assets[0];
        int index = 1;
        for (int i = 0; i < assets.length; i++) {
            if(assets[i] > max){
                max = assets[i];
                index = i+1;
            }

        }
        System.out.println();
        System.out.print("The biggest asset is: " + max + " position is: " + index);

    }
}
