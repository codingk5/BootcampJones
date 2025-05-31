package org.example;

import java.util.ArrayList;
import java.util.List;


public class Sandwich implements OrderItem {
    // holding all toppings

    private BreadSize breadSize;
    private boolean isToasted;
    private List<Topping> toppingsList;
    private List<VeggieOption> toppings = new ArrayList<>();
    private List<ProteinList> toppings1 = new ArrayList<>();

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

    public List<VeggieOption> getToppings() {
        return toppings;
    }

    // add topping to san
    public void addVeggieTopping(List<VeggieOption> topping) {

    }

    public void setToppings(List<VeggieOption> toppings) {
        this.toppings = toppings;
    }


    public void setToppings1(List<ProteinList> toppings1){this.toppings = toppings;}

    public void setSauces(List<Sauces> sauces) {
    }


    public void addTopping(List<Topping> topping){
        this.toppingsList.addAll(topping);
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

