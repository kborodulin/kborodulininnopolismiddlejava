package ru.kborodulin.dz_3.task_1;

/**
 * Задание 1. Написать класс MathBox, реализующий следующий функционал:
 * <p>
 * Конструктор на вход получает массив Number. Элементы не могут повторяться.
 * Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
 * Существует метод summator, возвращающий сумму всех элементов коллекции.
 * Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
 * являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
 * Необходимо правильно переопределить методы toString, hashCode, equals, чтобы можно было использовать
 * MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
 * Выполнение контракта обязательно!
 * Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Init Collection----------------------------");
        Number[] arrNumbers = new Number[]{10, 30L, 20, 15, 5, 20, 20.7};
        MathBox mathBox = new MathBox(arrNumbers);
        for (Object number : mathBox.getNumberSet()) {
            System.out.println(number);
        }

        System.out.println("\nSummator----------------------------");
        System.out.println(mathBox.summator());

        System.out.println("\nSplitter----------------------------");
        mathBox.splitter(2);
        for (Object number : mathBox.getNumberSet()) {
            System.out.println(number);
        }

        System.out.println("\nCheckDeleteIntegerBefore----------------------------");
        for (Object number : mathBox.getNumberSet()) {
            System.out.println(number.getClass());
        }

        System.out.println("\nCheckDeleteIntegerAfter----------------------------");
        mathBox.deleteValueCollectionForInteger();
        for (Object number : mathBox.getNumberSet()) {
            System.out.println(number.getClass());
        }
    }
}
