package ru.innopolis.dz_2.task_1;

/**
 * Задание 1. Написать программу ”Hello, World!”. В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 * <p>
 * Смоделировав ошибку «NullPointerException»
 * Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * Вызвав свой вариант ошибки через оператор throw
 */
public class App {
    public static void main(String[] args) {
        SimulateError simulateError = new SimulateError();
        simulateError.npe();
        simulateError.arrIndexBoundException();
        simulateError.myException();
        System.out.println("Hello, World!");
    }
}
