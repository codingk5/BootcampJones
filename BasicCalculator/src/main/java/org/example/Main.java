package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the first character of the operation.");
        String operation = scanner.nextLine();

        System.out.println("Input your first number.");
        int num1 = scanner.nextInt();
        System.out.println("Input your second number.");
        int num2 = scanner.nextInt();




        switch (operation){
            case "A":
                System.out.println("You are doing addition.");
                int total = num2 + num1;
                System.out.println(total);
                break;
            case "S":
                System.out.println("You are doing Subtraction.");
                int total1 = num2 - num1;
                System.out.println(total1);
                break;
            case "M":
                System.out.println("You are doing multiplication.");
                int total2 = num2 * num1;
                System.out.println(total2);
                break;
            case "D":
                System.out.println("You are doing division.");
                int total3 = num2 / num1;
                System.out.println(total3);
                break;


        }







    }
}