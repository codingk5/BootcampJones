package org.example;

import java.util.ArrayList;
import java.util.List;


public class Sandwich implements OrderItem {
    // holding all toppings

    private BreadSize breadSize;
    private boolean isToasted;
    private List<Topping> toppingsList;
    private ArrayList<VeggieOption> toppings = new ArrayList<>();

    public Sandwich(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(BreadSize breadSize) {
        this.breadSize = breadSize;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public ArrayList<VeggieOption> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<VeggieOption> toppings) {
        this.toppings = toppings;
    }
    // add topping to san
    public void addVeggieTopping(VeggieOption topping) {
        this.toppings.add(topping);
    }

    public void setSauces(List<Sauces> sauces) {
    }

    public void addTopping(Topping topping){
        this.toppingsList.add(topping);
    }

    @Override
    public double getCost() {
        double sum = 0;
        for(Topping topping : toppingsList){
            sum += topping.getCost(this.breadSize);
        }

        return sum;
    }

    @Override
    public String getReceiptName() {
        String receipt = breadSize + " Sandwich";
        if (isToasted) {
            receipt += " (Toasted)";
        }

        if (!toppings.isEmpty()) {
            receipt += " with ";
            for (int i = 0; i < toppings.size(); i++) {
                receipt += toppings.get(i);
                if (i < toppings.size() - 1) {
                    receipt += ", ";
                }
            }
        }

        return receipt;
    }
}

