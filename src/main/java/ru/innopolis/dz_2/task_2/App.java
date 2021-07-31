package ru.innopolis.dz_2.task_2;

/**
 * Задание 2. Составить программу, генерирующую N случайных чисел.
 * Для каждого числа k вычислить квадратный корень q. Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 */
public class App {
    public static void main(String[] args) throws Exception {
        NumberGenerator numberGenerator = new NumberGenerator();
        System.out.println(numberGenerator.numberRandom());
    }
}
