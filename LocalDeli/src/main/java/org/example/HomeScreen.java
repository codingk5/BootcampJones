package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javax.swing.text.StyleConstants.Size;
import static org.example.Drink.*;

public class HomeScreen {
    public static Sandwich main(String[] args) {


        Scanner scanner = new Scanner(System.in);




        while (true) {
            System.out.println("---Welcome To The Local Deli---\n");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Check Out");
            System.out.println("0) Cancel");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    HomeScreen.buildSandwich();
                    OrderItem.add(sandwich);
                    System.out.println("Sandwich Built");
                    break;
                case 2:
                    System.out.println("Select drink.");
                    System.out.println("Sprite");
                    System.out.println("Strawberry Tea");
                    System.out.println("Blueberry Lemonade");

                    String drinkName = scanner.nextLine();

                    System.out.println("Choose size : Small, Medium. Large");
                    String drinkSize = scanner.nextLine();
                    Drink drink = new Drink(drinkName, drinkSize);

                    order.addItemToOrder(drink);
                    System.out.println("added drink");
                    break;
                case 3:
                    System.out.println("Select chip\n");
                    System.out.println("Lays");
                    System.out.println("Cheetos");
                    System.out.println("Doritos");
                    System.out.println("Sun Chips");

                    String chip = scanner.nextLine();
                    Chips chips = new Chips(chip);

                    System.out.println("Chips Added");

                case 4:
                    checkOut();
                    System.out.println("Thanks for visiting, come again.");
                    break;





            }

        }




        private static void buildSandwich() {

            // Ask for bread size
            System.out.println("What size sandwich would you like? (e.g., 4in, 6in, 8in)");
            String breadSizeInput = scanner.nextLine();
            BreadSize size = BreadSize.valueOf(breadSizeInput.toUpperCase());
            Sandwich sandwich = new Sandwich(size);


            // Ask for bread type
            System.out.println("What type of bread would you like? (e.g., WHITE, WHEAT, SOURDOUGH, RYE)");
            String breadTypeInput = scanner.nextLine().toUpperCase();


            try {
                BreadType breadType = BreadType.valueOf(breadTypeInput);
                BreadType.setBreadType(breadType);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid bread type. Skipping.");
            }

            // Ask for meat
            System.out.println("Would you like meat? (yes, no, extra to skip)");
            String meatChoice = scanner.nextLine().toLowerCase();
            if (meatChoice.equals("yes")) {
                System.out.println("What type of meat would you like?");
                String proteinType = scanner.nextLine().toUpperCase();
                try {
                    ProteinList proteinList = ProteinList.valueOf(proteinType);
                    Topping.setToppingType(proteinList.name());
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid meat. Skipping.");
                }
            }

            // Ask for cheese
            System.out.println("Would you like cheese? (yes, no, extra to skip)");
            String cheeseChoice = scanner.nextLine().toLowerCase();
            if (cheeseChoice.equals("yes")) {
                System.out.println("What kind of cheese?");
                String cheeseType = scanner.nextLine().toUpperCase();
                try {
                    CheeseOption cheese = CheeseOption.valueOf(cheeseType);
                    Cheese.setCheeseOption(cheese);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid cheese. Skipping.");
                }
            }

            // Ask for toppings
            System.out.println("Choose your toppings (type 'done' when finished):");
            for (VeggieOption v : VeggieOption.values()) {
                System.out.println("- " + v.name().toLowerCase());
            }

            ArrayList<VeggieOption> toppings = new ArrayList<>();
            while (true) {
                String toppingInput = scanner.nextLine().toUpperCase();
                if (toppingInput.equals("DONE")) break;
                try {
                    VeggieOption topping = VeggieOption.valueOf(toppingInput);
                    toppings.add(topping);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid topping. Try again.");
                }
            }
            sandwich.setToppings(toppings);

            // Ask for sauces
            System.out.println("Choose your sauces (type 'done' when finished):");
            for (Sauces sauces : Sauces.values()) {
                System.out.println("- " + sauces.name().toLowerCase());
            }

            List<Sauces> sauces = new ArrayList<>();
            while (true) {
                String sauceInput = scanner.nextLine().toUpperCase();
                if (sauceInput.equals("DONE")) break;
                try {
                    Sauces sauce1 = Sauces.valueOf(sauceInput);
                    sauces.add(sauce1);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid sauce. Try again.");
                }
            }
            sandwich.setSauces(sauces);

            return sandwich;
        }
        }
    }










