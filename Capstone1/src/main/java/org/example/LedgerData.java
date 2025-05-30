package org.example;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.LedgerReports.showReports;

public class LedgerData {
    public static void showLedger(List<Transaction> transaction, Scanner scanner) {

        while(true) {
            System.out.println("Ledger Screen\n");
            System.out.println("A) Show All Entries");
            System.out.println("B) Show Deposits");
            System.out.println("C) Show Payments");
            System.out.println("D) Show Reports");
            System.out.println("E) Return to Home Screen");

            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "A":
                    displayTransactions(transaction);
                    break;
                case "B":
                    displayTransactions(getAllDeposits());
                    break;
                case "C":
                    displayTransactions(getAllPayments());
                    break;
                case "D":
                    showReports(transaction,scanner);
                    break;
                case "E":
                    return;





            }



        }
    }



    public static void displayTransactions(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No available transactions.");
            return;
        }
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

    }

    public static List<Transaction> getAllDeposits() {
        List<Transaction> ledgerData = FileManager.readFile();
        List<Transaction> deposits = new ArrayList<>();

        for (Transaction transaction : ledgerData) {
            if (transaction.getAmount() > 0) {
                deposits.add(transaction);
            }
        }
        return deposits;
    }
    public static List<Transaction> getAllPayments() {
        List<Transaction> ledgerData = FileManager.readFile();
        List<Transaction> payments = new ArrayList<>();

        for (Transaction transaction : ledgerData) {
            if (transaction.getAmount() < 0) {
                payments.add(transaction);
            }
        }
       return payments;
    }





}
