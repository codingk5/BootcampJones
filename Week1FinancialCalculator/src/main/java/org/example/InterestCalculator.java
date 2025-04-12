package org.example;

import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is youe monthly payment?");
        float monthlyPayment = scanner.nextFloat();

        System.out.println("What is your principal?");
        float principal = scanner.nextFloat();

        System.out.println("What is your annual interest rate?");
        float annualInterestRate = scanner.nextFloat();

        System.out.println("What is your term length in years?");
        float longTermYears = scanner.nextFloat();

        double M = monthlyPayment;
        double P = principal;
        double r = annualInterestRate;
        double y = longTermYears;
        double n = 12 * y;
        double i = r / 12;

        double totalInterest = (M * n)-P;

        }
    }

