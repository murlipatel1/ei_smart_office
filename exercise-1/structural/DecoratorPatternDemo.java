// Component Interface
interface Pizza {
    String makePizza();
}

// Concrete Component
class PlainPizza implements Pizza {
    @Override
    public String makePizza() {
        return "Plain Pizza";
    }
}

// Decorator
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return pizza.makePizza();
    }
}

// Concrete Decorators
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String makePizza() {
        return pizza.makePizza() + " + Cheese";
    }
}

class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String makePizza() {
        return pizza.makePizza() + " + Pepperoni";
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Pizza plainPizza = new PlainPizza();
        Pizza cheesePizza = new CheeseDecorator(plainPizza);
        Pizza pepperoniCheesePizza = new PepperoniDecorator(cheesePizza);

        System.out.println(plainPizza.makePizza());  // Plain Pizza
        System.out.println(cheesePizza.makePizza());  // Plain Pizza + Cheese
        System.out.println(pepperoniCheesePizza.makePizza());  // Plain Pizza + Cheese + Pepperoni
    }
}
