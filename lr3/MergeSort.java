import java.util.Arrays; // Импортируем класс Arrays для работы с массивами
import java.util.Scanner; // Импортируем класс Scanner для ввода данных с клавиатуры

public class MergeSort {

    // Метод для сортировки массива с помощью алгоритма сортировки слиянием
    public static void mergeSort(int[] array) {
        // Если длина массива меньше или равна 1, то он уже отсортирован
        if (array.length <= 1) {
            return;
        }

        // Находим середину массива
        int mid = array.length / 2;
        // Копируем левую половину массива
        int[] left = Arrays.copyOfRange(array, 0, mid);
        // Копируем правую половину массива
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Рекурсивно сортируем обе половины
        mergeSort(left);
        mergeSort(right);
        // Объединяем отсортированные половины
        merge(array, left, right);
    }

    // Метод для объединения двух отсортированных массивов
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0; // Индексы для левой, правой и результирующей частей

        // Объединяем массивы, пока в обеих частях есть элементы
        while (i < left.length && j < right.length) {
            // Сравниваем текущие элементы из левой и правой частей
            if (left[i] <= right[j]) {
                array[k++] = left[i++]; // Добавляем элемент из левой части
            } else {
                array[k++] = right[j++]; // Добавляем элемент из правой части
            }
        }

        // Если остались элементы в левой части, добавляем их в результирующий массив
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Если остались элементы в правой части, добавляем их в результирующий массив
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Главный метод, точка входа в программу
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для ввода данных
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt(); // Читаем количество элементов массива

        int[] array = new int[n]; // Создаем массив указанного размера
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt(); // Читаем элементы массива
        }

        System.out.println("Original array: " + Arrays.toString(array)); // Выводим оригинальный массив
        mergeSort(array); // Сортируем массив
        System.out.println("Sorted array: " + Arrays.toString(array)); // Выводим отсортированный массив

        scanner.close(); // Закрываем сканер
    }
}
