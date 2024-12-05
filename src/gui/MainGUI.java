package gui;

import lr1.ConcreteDish;
import lr3.MergeSort;
import common.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MainGUI extends JFrame {

    private Repository<ConcreteDish> dishRepository = new Repository<>();

    public MainGUI() {
        setTitle("Главное меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JButton dishButton = new JButton("Управление блюдами");
        dishButton.addActionListener(e -> openDishWindow());

        JButton arrayButton = new JButton("Сортировка массива");
        arrayButton.addActionListener(e -> openArrayWindow());

        add(dishButton);
        add(arrayButton);

        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    private void openDishWindow() {
        JFrame dishFrame = new JFrame("Управление блюдами");
        dishFrame.setLayout(new BorderLayout());
        dishFrame.setSize(500, 400);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Название:"));
        JTextField nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Цена:"));
        JTextField priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Калорийность:"));
        JTextField caloriesField = new JTextField();
        inputPanel.add(caloriesField);

        inputPanel.add(new JLabel("Веган? (true/false):"));
        JTextField veganField = new JTextField();
        inputPanel.add(veganField);

        JButton addButton = new JButton("Добавить блюдо");
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int calories = Integer.parseInt(caloriesField.getText());
                boolean isVegan = Boolean.parseBoolean(veganField.getText());

                ConcreteDish newDish = new ConcreteDish(name, price, calories, isVegan);
                dishRepository.add(newDish);

                JOptionPane.showMessageDialog(dishFrame, "Блюдо добавлено!");
                nameField.setText("");
                priceField.setText("");
                caloriesField.setText("");
                veganField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dishFrame, "Ошибка ввода: " + ex.getMessage());
            }
        });

        JButton sortButton = new JButton("Сортировать блюда");
        sortButton.addActionListener(e -> {
            List<ConcreteDish> dishes = dishRepository.getAll();
            MergeSort.mergeSort(dishes);

            StringBuilder result = new StringBuilder("Сортированные блюда:\n");
            for (ConcreteDish dish : dishes) {
                result.append(dish.getName()).append(" - ").append(dish.getCalories()).append(" калорий\n");
            }
            JOptionPane.showMessageDialog(dishFrame, result.toString());
        });

        dishFrame.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(sortButton);

        dishFrame.add(buttonPanel, BorderLayout.SOUTH);
        dishFrame.setVisible(true);
    }

    private void openArrayWindow() {
        JFrame arrayFrame = new JFrame("Сортировка массива");
        arrayFrame.setLayout(new BorderLayout());
        arrayFrame.setSize(500, 300);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Введите числа через запятую:"), BorderLayout.NORTH);
        JTextField arrayField = new JTextField();
        inputPanel.add(arrayField, BorderLayout.CENTER);

        JButton sortButton = new JButton("Сортировать");
        sortButton.addActionListener(e -> {
            try {
                String[] input = arrayField.getText().split(",");
                int[] numbers = new int[input.length];
                for (int i = 0; i < input.length; i++) {
                    numbers[i] = Integer.parseInt(input[i].trim());
                }

                // Преобразуем массив в список
                List<Integer> numberList = Arrays.stream(numbers)
                        .boxed()
                        .collect(Collectors.toList());

                // Сортируем список
                MergeSort.mergeSort(numberList);

                StringBuilder result = new StringBuilder("Сортированный массив:\n");
                for (int num : numberList) {
                    result.append(num).append(" ");
                }
                JOptionPane.showMessageDialog(arrayFrame, result.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(arrayFrame, "Ошибка ввода: " + ex.getMessage());
            }
        });

        arrayFrame.add(inputPanel, BorderLayout.CENTER);
        arrayFrame.add(sortButton, BorderLayout.SOUTH);
        arrayFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI gui = new MainGUI();
            gui.setVisible(true);
        });
    }
}
