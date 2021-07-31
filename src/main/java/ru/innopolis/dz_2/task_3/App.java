package ru.innopolis.dz_2.task_3;

import java.util.Date;

/**
 * Задание 3. Дан массив объектов Person.
 * Класс Person характеризуется полями
 * age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN),
 * name (имя - строка).
 * Создать два класса, методы которых будут реализовывать сортировку объектов.
 * Предусмотреть единый интерфейс для классов сортировки.
 * Реализовать два различных метода сортировки этого массива по правилам:
 * <p>
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * <p>
 * Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.
 */
public class App {
    public static void main(String[] args) {
        // Сортировка пузырьком
        SortBubble sortBubble = new SortBubble();
        long startTime = new Date().getTime();
        Person[] arrPerson1 = sortBubble.sort();
        long endTime = new Date().getTime() - startTime;
        System.out.println("Сортировка пузырьком: " + (endTime / 1000) + " сек");
        /* for (Person person : arrPerson1) {
            System.out.println(person);
        } */

        // Сортировка выбором
        SortSelection sortSelection = new SortSelection();
        startTime = new Date().getTime();
        Person[] arrPerson2 = sortSelection.sort();
        endTime = new Date().getTime() - startTime;
        System.out.println("Сортировка выбором: " + (endTime / 1000) + " сек");
        /* for (int index = 0; index < arrPerson2.length; index++) {
            if (index + 1 != arrPerson2.length &&
                    arrPerson2[index].getName().equals(arrPerson2[index + 1].getName()) &&
                    arrPerson2[index].getAge() == arrPerson2[index + 1].getAge()) {
                System.out.println("имя " + arrPerson2[index].getName() +
                        " и возраст " + arrPerson2[index].getAge() + " совпадают");
            }
            System.out.println(index + " " + arrPerson2[index]);
        } */
    }
}