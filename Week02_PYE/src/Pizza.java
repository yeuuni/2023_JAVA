
class Circle {
    protected int radius;

    public Circle(int r) {
        radius = r;
    }

  
}

class Pizzza extends Circle {
    private String topping;

    public Pizzza(int r, String topping) {
        super(r);
        this.topping = topping;
    }

    public String getTopping() {
        return topping;
    }

  
}

public class Pizza {
    public static void main(String[] args) {
        Pizzza pizza = new Pizzza(20, "Pepperoni");
        System.out.println("Pizza Radius: " + pizza.radius);
        System.out.println("Pizza Topping: " + pizza.getTopping());
       
    }
}