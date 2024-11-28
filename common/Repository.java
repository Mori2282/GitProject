package common;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Dish> dishes;

    public Repository() {
        this.dishes = new ArrayList<>();
    }

    // Метод для добавления блюда
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    // Метод для удаления блюда
    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    // Метод для получения всех блюд
    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishes);
    }

    // Метод для получения блюд, подходящих для веганов
    public List<Dish> getVeganFriendlyDishes() {
        List<Dish> veganDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.isVeganFriendly()) {
                veganDishes.add(dish);
            }
        }
        return veganDishes;
    }

    // Метод для получения средней цены блюд с калориями более заданного значения
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
