package pizza.bill.generator;

public class PizzaDemo {
    public static void main(String[] args) {
        Pizza basePizza = new Pizza(false);
        basePizza.addExtraCheese();
        basePizza.addExtraToppings();
        basePizza.takeAway();
        System.out.println(basePizza.getBill());
    }
}
