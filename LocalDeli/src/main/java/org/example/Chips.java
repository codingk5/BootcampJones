package org.example;

public class Chips implements OrderItem {
    private String type;

    public Chips(String type){
        this.type = type;
    }

    public double getCost(){
            return 1.50;
        }

    @Override
    public String getReceiptName() {
        return this.type + " " + this.getCost();
    }
}



