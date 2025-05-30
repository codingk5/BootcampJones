package org.example;

public abstract class Topping {
    private  String name;
    private String toppingType;

    public Topping(String name, String toppingType) {
        this.name = name;
        this.toppingType = toppingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public double getCost(BreadSize breadSize) {
        return  getCost(breadSize);
    }
}
