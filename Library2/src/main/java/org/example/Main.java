package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] inventory = new Book[20];


        Book book1 = new Book(1, "978-0140449136", "The Odyssey", false, null);
        Book book2 = new Book(2, "978-0061120084", "To Kill a Mockingbird", false, null);
        Book book3 = new Book(3, "978-0451524935", "1984", true, "Alice");
        Book book4 = new Book(4, "978-0141182803", "The Great Gatsby", false, null);
        Book book5 = new Book(5, "978-0544003415", "The Hobbit", true, "Bob");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Pick 1 through 4");
            System.out.println("1)Available Books");
            System.out.println("2)Return Book");
            System.out.println("3)Checked Out Book");
            System.out.println("4) Exit");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    displayBooks(inventory);
                    break;
                case 2:
                    returnBook(inventory, scanner);
                    break;
                case 3:
                    isCheckedOut(inventory);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Try again.");

            }
        }
    }

    private static void isCheckedOut(Book[] inventory) {

            System.out.println("Book Out");

            boolean isCheckedOut = true;

            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] != null && inventory[i].isCheckedOut()) {
                    System.out.println(inventory[i].getCheckedOutTo() + "has" + inventory[i].getTitle() + ")");
                    isCheckedOut = false;

                }
                if (!isCheckedOut) {
                    System.out.println("All books are available.");


                }
            }



    }

    public static void displayBooks(Book[] inventory) {
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("Books Available " + inventory[i].getTitle());


            String title = inventory[i].getTitle();
            String status = inventory[i].getCheckedOutTo();
            System.out.println(inventory[i].getTitle());


        }
    }



    public static void returnBook(Book[] inventory, Scanner scanner) {
        System.out.println("Title of book you are returning");
        String bookReturned = scanner.nextLine();

        boolean isCheckedOut = false;

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].getTitle().equalsIgnoreCase(bookReturned)) {
                if (inventory[i].isCheckedOut()) {
                    inventory[i].returnBook();
                    System.out.println("Thanks, book returned.");
                } else {
                    System.out.println("Book Available");
                }
                isCheckedOut = true;
                break;




            }


        }


    }
}