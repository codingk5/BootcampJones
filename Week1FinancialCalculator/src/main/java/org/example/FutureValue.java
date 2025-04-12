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

        // FV = P * ( 1 + (r / 365))^(365 * t)





    }
}
