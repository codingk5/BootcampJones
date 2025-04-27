package org.example;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    //todo items add product to cart method
    public void addProductToCart(Product product) {
        products.add(product);


    }


    // todo remove product from cart
    //you will need the sku of the product you want to remove
    //loop through list of products
    //get that product then use remove method after loop
    public void removeProduct(String sku) {
        Product removeProduct = null;
        for (Product product : products) {
            if(product.getSku().equalsIgnoreCase(sku)) {
                removeProduct = product;
                break;

            }
        }
        if (removeProduct != null) {
            products.remove(removeProduct);
            System.out.println(sku + " has been removed.");

        } else {
            System.out.println("This  " + sku + " is not in your cart");
            printCart();
        }
        printCart();
    }


    // todo cart total method
    public double getCartTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }

        return total;


    }
    public void printCart() {
        if (products.isEmpty()) {
            System.out.println("No products in cart.");
        }
        else{
            for (Product product : products) {
                System.out.println(product.getProductName()  +  product.getPrice());
            }
        }

        }
}

