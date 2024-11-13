package library;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Dish> dishes;

    public Menu() {
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }

    public List<Dish> getVeganFriendlyDishes() {
        List<Dish> veganDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.isVeganFriendly()) {
                veganDishes.add(dish);
            }
        }
        return veganDishes;
    }

    public double getAveragePriceForHighCalorieDishes(int minCalories) {
        double total = 0;
        int count = 0;
        for (Dish dish : dishes) {
            if (dish.getCalories() > minCalories) {
                total += dish.getPrice();
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }
}
