package org.example;

import java.util.ArrayList;
import java.util.List;


public class Sandwich extends OrderItem {
    // holding all toppings

    private BreadSize breadSize;
    private boolean isToasted;
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
    public void addTopping(VeggieOption topping) {
        this.toppings.add(topping);
    }

    public void setSauces(List<Sauces> sauces) {
    }

    // setSauces list






    }

