package lr1;

import common.Repository;

public class Main {
    public static void main(String[] args) {
        // Используем конкретные блюда
        ConcreteDish dish1 = new ConcreteDish("Салат", 100.0, 200, true);
        ConcreteDish dish2 = new ConcreteDish("Суп", 150.0, 300, false);
        ConcreteDish dish3 = new ConcreteDish("Ризотто", 200.0, 400, true);

        // Репозиторий для хранения блюд
        Repository<Dish> repository = new Repository<>();
        repository.add(dish1);
        repository.add(dish2);
        repository.add(dish3);

        // Выводим все блюда
        System.out.println("Список блюд:");
        repository.getAll().forEach(dish -> System.out.println(dish.getName() + " - " + dish.getCalories() + " калорий"));
    }
}
