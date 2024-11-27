package common;

import library.Dish;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для управления коллекцией объектов типа Dish.
 * Позволяет добавлять, удалять, обновлять элементы и получать полный список.
 */
public class Repository {
    private List<Dish> dishes;

    public Repository() {
        this.dishes = new ArrayList<>();
    }

    /**
     * Добавление нового объекта в репозиторий.
     * @param dish объект типа Dish
     */
    public void add(Dish dish) {
        dishes.add(dish);
    }

    /**
     * Удаление объекта из репозитория.
     * @param dish объект типа Dish
     * @return true, если объект был успешно удален
     */
    public boolean remove(Dish dish) {
        return dishes.remove(dish);
    }

    /**
     * Обновление объекта в репозитории.
     * @param oldDish старый объект
     * @param newDish новый объект
     * @return true, если обновление прошло успешно
     */
    public boolean update(Dish oldDish, Dish newDish) {
        int index = dishes.indexOf(oldDish);
        if (index != -1) {
            dishes.set(index, newDish);
            return true;
        }
        return false;
    }

    /**
     * Получение всех объектов из репозитория.
     * @return список объектов типа Dish
     */
    public List<Dish> getAll() {
        return new ArrayList<>(dishes);
    }

    /**
     * Поиск блюд с калорийностью выше заданного значения.
     * @param minCalories минимальное количество калорий
     * @return список объектов типа Dish
     */
    public List<Dish> findByCalories(int minCalories) {
        List<Dish> result = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() > minCalories) {
                result.add(dish);
            }
        }
        return result;
    }
}
