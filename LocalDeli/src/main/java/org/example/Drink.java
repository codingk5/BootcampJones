package org.example;

public class Drink implements OrderItem {

   public String size;
   public double price;

    public Drink(String size) {
        this.size = size.toLowerCase();

       if (this.size.equals("small")){
           price = 2.00;
       }
       else if (this.size.equals("medium")){
           price = 2.50;
       }
       else if (this.size.equals("large")){
           price = 3.00;
       }
       else {
           price = 0.00;
       }
   }

   public String getSize(){
       return size;
   }
   public double getPrice() {
       return price;
   }

    @Override
    public double getCost() {
        return price;
    }

    @Override
    public String getReceiptName() {
        return "Drink: " + this.size + " " + this.price;
    }
}




