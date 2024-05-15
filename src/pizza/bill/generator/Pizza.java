package pizza.bill.generator;

public class Pizza {
    private double price;
    private Boolean isVeg;
    private int noOfCheese;
    private int noOfToppings;
    private int noOfTakeAways;
    double extraCheesePrice = 0.3;
    double extraToppingsPrice = 0.5;
    double backPackPrice = 0.1;

    Pizza(Boolean isVeg){
        this.isVeg = isVeg;

        if(this.isVeg){
            price = 3;
        }else {
            price = 4;
        }
    }

    public String getPrice() {
        return "$" + price ;
    }

    public void addExtraCheese(){
        price += extraCheesePrice;
        noOfCheese++;
    }

    public void addExtraToppings(){
        price += extraToppingsPrice;
        noOfToppings++;
    }

    public void takeAway(){
        price += backPackPrice;
        noOfTakeAways++;
    }

    public String getBill(){
        double totalCheeseBill = noOfCheese * extraCheesePrice;
        double totalToppingsBill = noOfToppings * extraToppingsPrice;
        double totalTakeAwayBill = noOfTakeAways * backPackPrice;
        double totalPizzaBill = Math.round(price - totalCheeseBill - totalToppingsBill - totalTakeAwayBill);
        String totalPrice = String.valueOf(price);

        if(totalPrice.indexOf('.') +1 == 0){
            totalPrice = totalPrice.substring(0, totalPrice.indexOf('.'));
        }else{
            totalPrice = totalPrice.substring(0, totalPrice.indexOf('.') + 2);
        }
        return "Your bill is: $" + totalPrice +
                            "\n\nMore Info -> " +
                            "\n\nOrdered Pizza Type: " + (isVeg ? " Veg" : " Non-veg") +
                            "\nPizza price: $" + totalPizzaBill +
                            "\nTotal extra cheese: " + noOfCheese + " -> $" + totalCheeseBill +
                            "\nTotal extra toppings: " + noOfToppings + " -> $" + totalToppingsBill +
                            "\nTotal backpacks: " + noOfTakeAways + " -> $" + totalTakeAwayBill +
                            "\n\nTotal price: $" + totalPrice;
    }
}
