package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HomeScreen {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

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
                    Sandwich sandwich = buildSandwich();
                    order.addSandwich(sandwich);
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
                    Drink drink = new Drink(drinkSize);

                    order.addDrink(drink);
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
                    order.addChips(chips);
                    System.out.println("Chips Added");
                    break;
                case 4:
                    FileManager.save(order);

                    System.out.println("Thanks for visiting, come again.");
                    break;
                case 0:
                    break;
            }

        }
    }

    private static Sandwich buildSandwich() {
        Scanner scanner = new Scanner(System.in);
        // Ask for bread size
        System.out.println("What size sandwich would you like? (e.g., four_inch, six_inch, eight_inch)");
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

        System.out.println("Choose your proteins (type 'done' when finished):");
        for (ProteinList p : ProteinList.values()) {
            System.out.println("- " + p.name().toLowerCase());
        }

        ArrayList<Topping> selectedProteins = new ArrayList<>();

        while (true) {
            String proteinInput = scanner.nextLine().toUpperCase();
            if (proteinInput.equals("DONE")) break;

            try {
                ProteinList proteinOption = ProteinList.valueOf(proteinInput);

                System.out.println("Would you like extra " + proteinOption.name().toLowerCase() + "? (yes/no)");
                String extraInput = scanner.nextLine().toLowerCase();
                boolean isExtra = extraInput.equals("yes");

                Protein proteinPick = new Protein(
                        proteinOption.name(),   // name
                        "Protein",              // toppingType
                        isExtra                 // extra
                );

                selectedProteins.add(proteinPick);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid protein. Try again.");
            }
            break;
        }

// Add all selected proteins to sandwich





        System.out.println("Choose your cheese (type 'done' when finished):");
        for (CheeseOption c : CheeseOption.values()) {
            System.out.println("- " + c.name().toLowerCase());
        }

        ArrayList<Topping> selectedCheeses = new ArrayList<>();

        while (true) {
            String cheeseInput = scanner.nextLine().toUpperCase();
            if (cheeseInput.equals("DONE")) break;

            try {
                CheeseOption cheeseOption = CheeseOption.valueOf(cheeseInput);

                System.out.println("Would you like extra " + cheeseOption.name().toLowerCase() + "? (yes/no)");
                String extraInput = scanner.nextLine().toLowerCase();
                boolean isExtra = extraInput.equals("yes");

                Cheese cheesePick = new Cheese(
                        cheeseOption.name(),     // name
                        "Cheese",                // toppingType
                        cheeseOption,            // enum value
                        isExtra                  // extra or not
                );

                selectedCheeses.add(cheesePick);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid cheese. Try again.");
            }
            break;
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






            return sandwich;
        }



}











