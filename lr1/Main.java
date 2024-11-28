package library;

public class Main {
    public static void main(String[] args) {
        // Создаем меню
        Menu menu = new Menu();

        // Добавляем блюда
        menu.addDish(new Drink("Coca Cola", 1.50, 150, false));
        menu.addDish(new Drink("Orange Juice", 2.00, 120, true));
        menu.addDish(new Drink("Water", 1.00, 0, true));
        menu.addDish(new Toast("Cheese Toast", 3.50, 400, false));
        menu.addDish(new Toast("Avocado Toast", 4.00, 350, true));
        menu.addDish(new Toast("Peanut Butter Toast", 3.00, 320, true));
        menu.addDish(new Drink("Coffee", 2.50, 100, true));
        menu.addDish(new Drink("Smoothie", 5.00, 350, true));
        menu.addDish(new Toast("Ham Toast", 4.50, 500, false));
        menu.addDish(new Toast("Egg Toast", 4.00, 300, false));

        // Выводим все блюда
        System.out.println("Все блюда:");
        for (Dish dish : menu.getAllDishes()) {
            System.out.println(dish);
        }

        // Выводим все блюда, подходящие для веганов
        System.out.println("\nVegan Friendly блюда:");
        for (Dish dish : menu.getVeganFriendlyDishes()) {
            System.out.println(dish);
        }

        // Рассчитываем и выводим среднюю цену блюд с калориями более 300
        double averagePrice = menu.getAveragePriceForHighCalorieDishes(300);
        System.out.println("\nСредняя цена блюд с калорийностью более 300: " + averagePrice);
    }
}
