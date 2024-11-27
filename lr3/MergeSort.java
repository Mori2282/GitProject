import common.Repository;
import library.Dish;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);

        // Заполнение репозитория данными
        System.out.print("Введите количество блюд: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Пропустить символ новой строки
        for (int i = 0; i < n; i++) {
            System.out.print("Введите название блюда: ");
            String name = scanner.nextLine();
            System.out.print("Введите цену: ");
            double price = scanner.nextDouble();
            System.out.print("Введите калорийность: ");
            int calories = scanner.nextInt();
            System.out.print("Подходит для веганов (true/false): ");
            boolean isVegan = scanner.nextBoolean();
            scanner.nextLine(); // Пропустить символ новой строки
            repository.add(new Dish(name, price, calories, isVegan));
        }

        // Работа с массивом цен
        double[] prices = repository.getAll().stream().mapToDouble(Dish::getPrice).toArray();
        System.out.println("Цены до сортировки: " + Arrays.toString(prices));
        mergeSort(prices);
        System.out.println("Цены после сортировки: " + Arrays.toString(prices));

        scanner.close();
    }

    public static void mergeSort(double[] array) {
        if (array.length <= 1) {
            return;
        }
        int mid = array.length / 2;
        double[] left = Arrays.copyOfRange(array, 0, mid);
        double[] right = Arrays.copyOfRange(array, mid, array.length);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(double[] array, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            array[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }
}
