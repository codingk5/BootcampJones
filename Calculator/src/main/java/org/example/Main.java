package org.example;

import java.util.Scanner;
import java.util.function.DoubleFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Pick two numbers between 0 and 100.");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int totalNum = num1 + num2;

        System.out.printf("The sum of %d and %d is %d", num1, num2, totalNum);

    }

    {
        // Payroll Calculator

        String employeeName = "Kay Jones";
        float payRate = 20.50f;
        int weeklyHrs = 48;

        float totalPay = (payRate * weeklyHrs);
        System.out.printf(employeeName + "worked" + weeklyHrs + "this week making a sum of " + totalPay);
    }

    //
}

