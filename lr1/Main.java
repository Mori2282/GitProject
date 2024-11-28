import common.Repository;
import library.*;

public class Main {
    public static void main(String[] args) {
        // Создаем репозиторий
        Repository repository = new Repository();

        // Добавляем 10 различных блюд
        repository.add(new Drink("Coca Cola", 1.50, 150, false));
        repository.add(new Drink("Orange Juice", 2.00, 120, true));
        repository.add(new Drink("Water", 1.00, 0, true));
        repository.add(new Toast("Cheese Toast", 3.50, 400, false));
        repository.add(new Toast("Avocado Toast", 4.00, 350, true));
        repository.add(new Toast("Peanut Butter Toast", 3.00, 320, true));
        repository.add(new Drink("Coffee", 2.50, 100, true));
        repository.add(new Drink("Smoothie", 5.00, 350, true));
        repository.add(new Toast("Ham Toast", 4.50, 500, false));
        repository.add(new Toast("Egg Toast", 4.00, 300, false));

        // Выводим все блюда
        System.out.println("Все блюда:");
        for (Dish dish : repository.getAll()) {
            System.out.println(dish);
        }

        // Выводим все блюда, подходящие для веганов
        System.out.println("\nVegan Friendly блюда:");
        for (Dish dish : repository.getAll()) {
            if (dish.isVeganFriendly()) {
                System.out.println(dish);
            }
        }

        // Рассчитываем и выводим среднюю цену блюд с калориями более 300
        double total = 0;
        int count = 0;
        for (Dish dish : repository.findByCalories(300)) {
            total += dish.getPrice();
            count++;
        }
        System.out.println("\nСредняя цена блюд с калорийностью более 300: " + (count > 0 ? total / count : 0));
    }
}
