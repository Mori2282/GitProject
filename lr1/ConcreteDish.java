package lr1;

public class ConcreteDish extends Dish implements Comparable<ConcreteDish> {
    private boolean isVegan;

    // Конструктор с четырьмя параметрами
    public ConcreteDish(String name, double price, int calories, boolean isVegan) {
        super(name, price, calories);  // Вызов конструктора родительского класса Dish
        this.isVegan = isVegan;
    }

    // Геттер для isVegan
    public boolean isVegan() {
        return isVegan;
    }

    // Сеттер для isVegan
    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    // Реализация метода compareTo для сравнения по калориям
    @Override
    public int compareTo(ConcreteDish other) {
        return Integer.compare(this.getCalories(), other.getCalories());
    }
}
