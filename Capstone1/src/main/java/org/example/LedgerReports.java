package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LedgerReports {

    public static void showReports(List<Transaction> transactions, Scanner scanner) {
        while (true) {
            System.out.println("Reports Menu\n");
            System.out.println("A) Month to Date");
            System.out.println("B) Search by Vendor");
            System.out.println("C) Back to Ledger");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    showMonthToDate();
                    break;

                case "B":
                    List<Transaction> vendorResults = searchByVendor(scanner);
                    displayTransactions(vendorResults);
                    break;

                case "C":
                    return;

                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }
    public static void showMonthToDate() {
        List<Transaction> transactions = FileManager.readFile();
        LocalDate now = LocalDate.now();
        System.out.println(" Month to Date Transactions \n");

        for (Transaction transaction : transactions) {
            if (transaction.getTransactionDate().getMonth() == now.getMonth() && transaction.getTransactionDate().getYear() == now.getYear()) {
                System.out.println(transaction);
            }
        }
    }
    public static List<Transaction> searchByVendor(Scanner scanner) {
        List<Transaction> matched = new ArrayList<>();
        List<Transaction> transactions = FileManager.readFile();

        System.out.println("Enter vendor name to search");
        String vendorInput = scanner.nextLine().trim().toLowerCase();

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().toLowerCase().contains(vendorInput)) {
                matched.add(transaction);
            }
        }

        if (matched.isEmpty()) {
            System.out.println("No transactions found for vendor " + vendorInput);
        }

        return matched;
    }
    public static void displayTransactions(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction transaction: transactions) {
            System.out.println(transaction);
        }
    }




}
