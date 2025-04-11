package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.println("What is your current Principal?");
        float principal = scanner.nextFloat();

        System.out.println("What is your current Interest Rate?");
        float annualInterestRate = scanner.nextFloat();

        System.out.println("What is your current Loan Length?");
        int loanLength = scanner.nextInt();
        double n = loanLength * 12;

        System.out.println("Your total of " + n + " months on this loan.");

        float monthlyRate = annualInterestRate/ 12 / 100;
        System.out.println("Your months to be paid is " + monthlyRate);

        double monthlyPayment = n * 12;
        System.out.println("Your monthly payment is " + monthlyPayment);



        double P = principal;
        double r = monthlyRate;
        double M = monthlyPayment;



        //M = P[r(1+r)^n] / [(1+r)^n-1]
        double k = 1 + r;
        double j = Math.pow(k,n);
        double left = P*(r*j);
        double right = j - 1;
        double z = left/right;
//  z eqauls months to pay
        double totalInterest =  (z * n) - P;
        System.out.printf("Your total monthly rate is $%.2f ", z);
        System.out.printf("Your total interest rate is $%.2f ", totalInterest);

        scanner.close();


        {

        }












    }
}