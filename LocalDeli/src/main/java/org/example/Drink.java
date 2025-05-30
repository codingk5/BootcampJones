package org.example;

public class Drink {

   public String size;
   public double price;

    public Drink(String size, double price) {
        this.size = size.toLowerCase();
        this.price = price;


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
    }




