package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while(true) {
            // main menu

            System.out.println("Welcome To The Payroll Calculator.");
            System.out.println("What is your employee id number?");

            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:

                case 2:

                case 3:

            }




        }




    }
    public static void grossPay() {

    }
    public static void payrollFile(String employeeFile) {

        try {
            FileReader fileReader = new FileReader(employeeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);

            }

            bufferedReader.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();

        }
        catch (Exception ex){

        }





    }

}