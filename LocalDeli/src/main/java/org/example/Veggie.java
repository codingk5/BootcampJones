package org.example;

public class Veggie extends Topping {



    private VeggieOption veggieType;

    public Veggie(String name, String toppingType,
                   VeggieOption veggieType) {
        super(name, toppingType);

        this.veggieType = veggieType;
    }

    public VeggieOption getVeggieType() {
        return veggieType;
    }

    public void setVeggieType(VeggieOption veggieType) {
        this.veggieType = veggieType;
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








