package org.example;



public class Cheese extends Topping {



    private CheeseOption cheeseOption;
    private boolean isExtra;


    public Cheese(String name, String toppingType,
                  CheeseOption cheeseOption, boolean isExtra) {
        super(name, toppingType);

        this.cheeseOption = cheeseOption;
        this.isExtra = isExtra;

    }

    public CheeseOption getCheeseOption() {
        return cheeseOption;
    }

    public void setCheeseOption(CheeseOption cheeseOption) {
        this.cheeseOption = cheeseOption;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }


    double baseCheese = 0.00;
    double extra = 0.00;



    @Override
    public double getCost(BreadSize breadSize) {
        switch (breadSize) {
            case FOUR_INCH:
                baseCheese = .75;
                if (isExtra) extra = 0.30;
                break;
            case EIGHT_INCH:
                baseCheese = 1.50;
                if (isExtra) extra = 0.60;
                break;
            case TWELVE_INCH:
                baseCheese = 2.25;
                if (isExtra) extra = .90;
        }

        return baseCheese + extra;


    }
}

