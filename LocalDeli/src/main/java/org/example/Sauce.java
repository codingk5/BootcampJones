package org.example;

public class Sauce extends Topping {


    public Sauces sauces;

    public Sauce(String name, String toppingType, Sauces sauces) {
        super(name, toppingType);
        this.sauces = sauces;
    }

    public Sauces getSauces() {
        return sauces;
    }

    public void setSauces(Sauces sauces) {
        this.sauces = sauces;
    }

    @Override
    public double getCost(BreadSize breadSize) {
        switch (breadSize) {
            case FOUR_INCH, EIGHT_INCH, TWELVE_INCH -> {
                return 0.0;
            }
        }
        return  0;
    }


}




    // methods



