package org.example;
import java.util.ArrayList;
import java.util.List;



public class OrderItem extends CheckOut{

        private List<Sandwich> sandwiches = new ArrayList<>();
        private List<Chips> chipsList = new ArrayList<>();
        private List<Drinks> drinksList = new ArrayList<>();
        private List<OrderItem> items = new ArrayList<>();


        public void addSandwich(Sandwich sandwich) {
            sandwiches.add(sandwich);
        }

        public void addChips(Chips chips) {
            chipsList.add(chips);
        }

        public void addDrink(Drinks drinks) {
            drinksList.add(drinks);
        }

        public void addItemToOrder(OrderItem item) {
            this.items.add(item);
        }

        public List<OrderItem> getOrderItems() {
            return items;
        }


        public double getToTalCost() {
            double total = 0.0;

            for(OrderItem item: items){
                total+= item.getItemTotal();
            }
            return total;
        }
    }


