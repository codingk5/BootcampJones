package org.example;


public class Protein extends Topping  {


    public boolean isExtra;
    public double baseProtein;
    public double extra;

    public Protein(String name, String toppingType,
                   boolean isExtra, double baseProtein, double extra) {
        super(name, toppingType);
        this.isExtra = isExtra;
        this.baseProtein = baseProtein;
        this.extra = extra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public double getBaseProtein() {
        return baseProtein;
    }

    public void setBaseProtein(double baseProtein) {
        this.baseProtein = baseProtein;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    @Override
    public double getCost(BreadSize breadSize){
    switch (breadSize) {
        case FOUR_INCH:
            baseProtein = 1.00;
            if(isExtra) extra = .50;
            break;
        case EIGHT_INCH:
            baseProtein = 2.00;
            if(isExtra) extra = 1.00;
            break;
        case TWELVE_INCH:
            baseProtein = 3.00;
            if(isExtra) extra = 1.50;
            break;

    }
        return baseProtein + extra;
    }
    }












