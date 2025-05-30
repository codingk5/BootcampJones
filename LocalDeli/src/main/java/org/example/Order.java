package org.example;
import java.util.ArrayList;
import java.util.List;



public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Chips> chipsList = new ArrayList<>();
    private List<Drink> drinkList = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addChips(Chips chips) {
        chipsList.add(chips);
    }

    public void addDrink(Drink drink){
        drinkList.add(drink);
    }

    public List<OrderItem> getOrderItems(){

        List<OrderItem> orderItems = new ArrayList<>(sandwiches);
        orderItems.addAll(drinkList);
        orderItems.addAll(chipsList);

        return orderItems;
    }
}


