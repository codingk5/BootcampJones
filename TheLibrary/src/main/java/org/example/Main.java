package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] inventory = new Book[20];

        // Add some books to inventory
        inventory[0] = new Book(1, "978-0140449136", "The Odyssey", false, null);
        inventory[1] = new Book(2, "978-0061120084", "To Kill a Mockingbird", false, null);
        inventory[2] = new Book(3, "978-0451524935", "1984", true, "Alice");
        inventory[3] = new Book(4, "978-0141182803", "The Great Gatsby", false, null);
        inventory[4] = new Book(5, "978-0544003415", "The Hobbit", true, "Bob");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pick 1 through 4:");
            System.out.println("1) Available Books");
            System.out.println("2) Return Book");
            System.out.println("3) Checked Out Books");
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
                    checkOutBook(inventory, scanner);
                    break;
                case 4:
                    System.out.println("Thank You Come Back and Visit Us!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option not available, try again.");
            }
        }
    }
    // i used the Book book : inventory. My i's kept coming back with an error

    public static void checkOutBook(Book[] inventory, Scanner scanner) {
        System.out.println("Book In Stock");
        for (Book book : inventory) {
            if (book != null && book.isCheckedOut()) {
                System.out.println(book.getTitle() + " (Checked out by " + book.getCheckedOutTo() + ")");
            }

            System.out.println("Name of Book");
            scanner.nextLine();
            System.out.println("You have checked out " + book.getTitle());
            return;

        }
    }

    public static void displayBooks(Book[] inventory) {
        System.out.println("Available Books");
        for (Book book : inventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println(book.getTitle());
            }
        }
    }

    public static void returnBook(Book[] inventory, Scanner scanner) {
        System.out.println("Name of the book you're returning:");
        String returnBookTitle = scanner.nextLine();

        boolean isCheckedIn = false;

        for (Book book : inventory) {
            if (book != null && book.getTitle().equalsIgnoreCase(returnBookTitle)) {
                if (book.isCheckedOut()) {
                    book.returnBook();
                    System.out.println("The book has been returned.");
                } else {
                    System.out.println("That book is available.");
                }
                isCheckedIn = true;
                break;
            }
        }

        if (!isCheckedIn) {
            System.out.println("Book not available.");
        }
    }


}




