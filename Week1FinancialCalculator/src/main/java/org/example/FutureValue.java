package org.example;

import java.util.Scanner;

public class FutureValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // What do we need from user

        System.out.println("What would you like to deposit?");
        double P = scanner.nextDouble();

        System.out.println("What is your current interest rate?");
        double r = scanner.nextDouble();


        System.out.println("What is the number of years?");
        double t = scanner.nextDouble();

      // FV = P( 1 + (r/n)^(n*t)


        double n = 365;
        double newR = (r / 100) / n;
        double FV = P * Math.pow(1 + newR, n * t);
        double intialPart = P * (1 + newR/n);
        double totalInterest = FV - P;

        System.out.printf("Your current value is %.2f. The interest collected is %.2f.", totalInterest, FV);


















    }
}
