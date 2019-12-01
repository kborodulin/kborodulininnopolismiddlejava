package ru.innopolis.dz_9.task_1;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // В рантайме компилируем SomeClass.java
        ClassOperations classOperations = new ClassOperations();
        String fileName = classOperations.compileSomeClass();
        // Загружаем SomeClass.class через ClassLoaders
        ClassLoader myClassLoader = new MyClassLoader();
        Class<?> loadClass = myClassLoader.loadClass(fileName);
        // Создаем объект загруженного класса и выполняем метод
        Worker someClass = (Worker) loadClass.newInstance();
        someClass.doWork();
    }
}