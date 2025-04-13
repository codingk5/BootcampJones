package org.example;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your monthly payment?");
        float monthlyPayment = scanner.nextFloat();
        double M = monthlyPayment;

        System.out.println("What is your principal?");
        float principal = scanner.nextFloat();
        double P = principal;

        System.out.println("What is your annual interest rate?");
        float annualInterestRate = scanner.nextFloat();
        double r = annualInterestRate;

        System.out.println("What is your term length in years?");
        float longTermYears = scanner.nextFloat();
        double y = longTermYears;





        double n = 12 * y;
        double totalInterest = r / 12;
        double k = (M * n) -P;


        System.out.printf("You monthly payment is %f. Your total interest is %.2f", k, totalInterest);

        }
    }

