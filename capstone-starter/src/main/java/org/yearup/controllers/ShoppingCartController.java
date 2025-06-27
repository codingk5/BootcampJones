package org.yearup.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProductDao;
import org.yearup.data.ShoppingCartDao;
import org.yearup.data.UserDao;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.models.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// convert this class to a REST controller
// only logged in users should have access to these actions
@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/cart")
public class ShoppingCartController
{
    // a shopping cart requires
    private ShoppingCartDao shoppingCartDao;
    private UserDao userDao;
    private ProductDao productDao;



    // each method in this controller requires a Principal object as a parameter
    public ShoppingCart getCart(Principal principal)
    {
        try
        {
            // get the currently logged in username
            String userName = principal.getName();
            // find database user by userId
            User user = userDao.getByUserName(userName);
            int userId = user.getId();

            // use the shoppingcartDao to get all items in the cart and return the cart
            return shoppingCartDao.getByUserId(userId);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    // add a POST method to add a product to the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be added

    private List<Map<String, Integer>> cartProducts = new ArrayList<>();

    @PostMapping("/products/{productId}")
    public ResponseEntity<?> addProductToCart(@PathVariable int productId) {
        if (productId <= 0) {
            return ResponseEntity.badRequest().body("Invalid product ID");
        }

        Map<String, Integer> product = new HashMap<>();
        product.put("productId", productId);
        cartProducts.add(product);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product " + productId + " added to cart");
        response.put("cart", cartProducts);

        return ResponseEntity.status(201).body(response);
    }


    // add a PUT method to update an existing product in the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be updated)
    // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated

    private Map<Integer, Integer> putCartProducts = new HashMap<>();


    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProductInCart(@PathVariable int productId,
                                                 @RequestBody ShoppingCartItem item) {
        if (!putCartProducts.containsKey(productId)) {
            return ResponseEntity.notFound().build(); // product not in cart
        }

        if (item.getQuantity() <= 0) {
            return ResponseEntity.badRequest().body("Quantity must be greater than 0");
        }

        putCartProducts.put(productId, item.getQuantity());

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Product " + productId + " updated in cart");
        response.put("productId", productId);
        response.put("newQuantity", item.getQuantity());

        return ResponseEntity.ok(response);
    }


    // add a DELETE method to clear all products from the current users cart
    // https://localhost:8080/cart

    @DeleteMapping
    public ResponseEntity<?> clearCart() {
        cartProducts.clear();

        Map<String, String> response = new HashMap<>();
        response.put("message", "Cart has been cleared");

        return ResponseEntity.ok(response);
    }


}
