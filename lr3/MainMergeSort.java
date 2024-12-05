package lr3;

import java.util.ArrayList;
import java.util.List;

public class MainMergeSort {
    public static void main(String[] args) {
        // Пример использования метода mergeSort для массива
        int[] array = {5, 2, 8, 1, 3};

        // Преобразуем массив в List<Integer>
        List<Integer> arrayList = new ArrayList<>();
        for (int num : array) {
            arrayList.add(num);
        }

        // Сортировка с использованием mergeSort
        MergeSort.mergeSort(arrayList);

        // Вывод отсортированного списка
        System.out.println("Отсортированный список:");
        for (int num : arrayList) {
            System.out.print(num + " ");
        }
    }
}
