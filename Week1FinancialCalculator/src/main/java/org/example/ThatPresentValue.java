package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class ThatPresentValue {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your monthly payout?");
        double pmt = scanner.nextDouble();


        System.out.println("What is your monthly interest rate?");
        double r = scanner.nextDouble();
        double newR = (r / 12 / 100);


        System.out.println("What is the number of years for payout?");
        double t = scanner.nextDouble();
        double n =(t * 12);

        // PV = PMT * [(1 - (1 + r)^(-n)) / r]
        // double newR = interestRate;

        double w = Math.pow((1 + newR),(-n));
        double PV = pmt * (1 - w)/newR;


        System.out.printf("Your present value is $%.2f", PV);



        }
    }







