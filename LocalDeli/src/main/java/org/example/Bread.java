package org.example;

public class Bread extends Topping{

    public Bread(String name, String toppingType) {
        super(name, toppingType);
    }

    @Override
    public double getCost(BreadSize breadSize) {
        switch (breadSize) {
            case FOUR_INCH -> {
                return 5.5;
            }
            case EIGHT_INCH -> {
                return 7.00;
            }
            case TWELVE_INCH ->
            {
                return 8.50;
            }
        }
        return  0;
    }

}

