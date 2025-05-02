package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        //Main Menu

        while (true) {

            System.out.println("Welcome to Your Personal Accountant.\n");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");


            Scanner scanner = new Scanner(System.in);

            String userInput = scanner.nextLine().trim().toUpperCase();


            switch (userInput) {
                case "D":
                    addDeposit(transactions, scanner);
                    break;
                case "P":
                    makePayment(transactions, scanner);
                    break;
                case "L":
                    LedgerData.showLedger(transactions, scanner);
                    break;
                case "X":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, try again.");


            }
        }


    }

    public static void addDeposit(List<Transaction> transactions, Scanner scanner) {
        System.out.println("Add Deposit");


        System.out.println("Enter purchase description.");
        String description = scanner.nextLine();

        System.out.println("Input Vendor.");
        String vendor = scanner.nextLine();

        System.out.println("Input Amount.");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction deposit = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        FileManager.appendTransaction(deposit);
        transactions.add(deposit);
        System.out.println("Transaction added!");
    }


    public static void makePayment(List<Transaction> transactions, Scanner scanner) {
        System.out.println("Amount you would like to pay.");
        double negativeAmount2 = Double.parseDouble(scanner.nextLine());

        System.out.println("Payment going out to.");
        String description = scanner.nextLine();

        System.out.println("Vendor for payment.");
        String vendor = scanner.nextLine();

        try {

             negativeAmount2 = negativeAmount2 * -1;

            Transaction payment = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor ,negativeAmount2);
            FileManager.appendTransaction(payment);
            transactions.add(payment);
            System.out.println("Payment of $ " + negativeAmount2 + " successful!");
        } catch (NumberFormatException ex) {
            System.out.println("Input invalid. Valid number needed.");
        }


    }

}