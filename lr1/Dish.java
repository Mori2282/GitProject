package library;

public abstract class Dish {
    private String name;
    private double price;
    private int calories;
    private boolean isVeganFriendly;

    public Dish(String name, double price, int calories, boolean isVeganFriendly) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.isVeganFriendly = isVeganFriendly;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isVeganFriendly() {
        return isVeganFriendly;;
    }

    @Override
    public String toString() {
        return "Блюдо: " + name + ", Цена: " + price + ", Калории: " + calories + ", Vegan Friendly: " + isVeganFriendly;
    }
}
