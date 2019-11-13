package ru.innopolis.dz_3.task_2;

/**
 * Задание 2. Создать класс ObjectBox, который будет хранить коллекцию Object.
 * <p>
 * У класса должен быть метод addObject, добавляющий объект в коллекцию.
 * У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
 * Должен быть метод dump, выводящий содержимое коллекции в строку.
 */
public class App {
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox();
        objectBox.addObject("Test1");
        objectBox.addObject("Test3");
        objectBox.addObject("Test5");
        objectBox.addObject(10);

        System.out.println("\nBefore delete----------------------------");
        for (Object object : objectBox.getSet()) {
            System.out.println(object);
        }

        System.out.println("\nAfter delete----------------------------");
        objectBox.deleteObject("Test3");
        for (Object object : objectBox.getSet()) {
            System.out.println(object);
        }

        System.out.println("\nPrint----------------------------");
        System.out.println(objectBox.dump());
    }

}
