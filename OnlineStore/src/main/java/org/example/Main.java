package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = FileManager.readFile();
        ShoppingCart cart = new ShoppingCart();


        while (true) {
            System.out.println("Welcome to All n One ");
            System.out.println("1. View all products");
            System.out.println("2. Search by SKU");
            System.out.println("3. Search by price range");
            System.out.println("4. Search by name");
            System.out.println("5. Add to cart");
            System.out.println("6. Remove from cart");
            System.out.println("7. View cart");
            System.out.println("8. Checkout");
            System.out.println("9. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayProducts(products);
                    break;
                case 2:
                    System.out.println("Please enter product sku.");
                    String sku = scanner.nextLine();
                    Product foundProduct = findBySku(products, sku);

                    if (foundProduct != null) {
                        System.out.println(foundProduct.getProductName() + "is in Stock");
                    }
                    break;
                case 3:
                    System.out.println("Enter minimum price:");
                    double minPrice = Double.parseDouble(scanner.nextLine());

                    System.out.println("Enter maximum price:");
                    double maxPrice = Double.parseDouble(scanner.nextLine());

                    List<Product> priceRange = filterByPriceRange(products, minPrice, maxPrice);

                   displayProducts(priceRange);

                    break;
                case 4:
                    System.out.println("Please enter the product name you would like to search.");
                    String searchByName = scanner.nextLine();
                    List<Product> productList = FileManager.readFile();
                    List<Product> matchingProducts = new ArrayList<>();

                    for (Product product : productList) {
                        if (product.getProductName().toLowerCase().contains(searchByName.toLowerCase()))matchingProducts.add(product);
                    }
                    if (matchingProducts.isEmpty()) {
                        System.out.println("No matching products for " + searchByName);
                    }
                    else {
                        System.out.println("Matching products " + searchByName);
                        displayProducts(matchingProducts);
                    }


                    // Prompt for name and call method to search products by name
                    break;
                case 5:
                    System.out.println("Would you like to add product to cart, input SKU");
                    List<Product> inStockProducts = FileManager.readFile();
                    sku = scanner.nextLine();
                    boolean productFound = false;
                    for (Product product : inStockProducts) {
                        if (product.getSku().equalsIgnoreCase(sku)) {
                            cart.addProductToCart(product);

                             break;

                        }
                    }
                    productFound = true;
                    if (!productFound) {
                        System.out.println("Product not found.");
                    }
                    break;



                    // Prompt for SKU, find product, and add to cart
                    //Remember to use the shopping cart we made above!

                case 6:
                    System.out.println("To remove product from cart enter SKU.");
                    String removeProduct = scanner.nextLine();
                    cart.removeProduct(removeProduct);
                    // Prompt for SKU to get the product, remove from cart
                    break;
                case 7:

                    cart.printCart();




                    // Display cart items. Remember, use the shopping cart above!
                    break;
                case 8:
                    System.out.printf("Cart total is $%.2f THANK YOU COME AGAIN", cart.getCartTotal());
                    // NEEDS SCANNER NEXT LINE
                    String cartTotal = scanner.nextLine();

                    // Display total and thank the user
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    //This method could be re-used over and over again if you play
    //your cards right!
    public static void displayProducts(List<Product> products) {
        for ( Product product : products){
            System.out.println("SKU: " + product.getSku() + " | " + product.getProductName() + "  | " +
                    "$" + product.getPrice() + " | " + product.getDept());
        }

    }

    public static Product findBySku(List<Product> products, String sku) {
        for (Product product : products) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                return product;

            }
        }
        return null;
    }

    // Returns a list of products with names that contain the search string (case-insensitive)
    public static List<Product> searchByName(List<Product> products, String productName) {
        List<Product> matches = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {

            }
            // If product name contains the search string, add to matches
        }
        return matches;
    }

    // Returns a list of products within the given price range (inclusive)
    public static List<Product> filterByPriceRange(List<Product> products, double min, double max) {
        List<Product> matches = new ArrayList<>();

        for(Product product : products){
            double price = product.getPrice();
            if (price >= min && price <= max) {
                matches.add(product);
            }



        }
        // If product price is between min and max, add to matches
        return matches;
    }

    }






