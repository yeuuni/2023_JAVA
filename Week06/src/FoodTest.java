import java.util.ArrayList;
import java.util.List;

enum Type {
    MEAT, FISH, OTHER
}

class Food {
    private String name;
    private int calories;
    private Type type;

    public Food(String name, int calories, Type type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
}

public class FoodTest {

    public static void main(String[] args) {
        List<Food> menu = new ArrayList<>();

        // Sample menu items
        menu.add(new Food("Salad", 150, Type.OTHER));
        menu.add(new Food("Chicken", 250, Type.MEAT));
        menu.add(new Food("Beef Stew", 350, Type.MEAT));
        menu.add(new Food("Vegetable Stir-fry", 200, Type.OTHER));
        menu.add(new Food("Fish Tacos", 280, Type.FISH));

        // Extract food names that are vegetarian and have calories less than or equal to 300
        List<String> vegetarianUnder300Calories = new ArrayList<>();
        for (Food food : menu) {
            if (food.getType() != Type.MEAT && food.getCalories() <= 300) {
                vegetarianUnder300Calories.add(food.getName());
            }
        }

        // Print the food names that meet the criteria
        System.out.println("Vegetarian food with calories <= 300:");
        for (String foodName : vegetarianUnder300Calories) {
            System.out.println(foodName);
        }
    }
}