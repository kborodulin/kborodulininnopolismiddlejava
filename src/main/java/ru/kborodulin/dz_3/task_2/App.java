package ru.kborodulin.dz_3.task_2;

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
