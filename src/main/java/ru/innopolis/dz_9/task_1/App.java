package ru.innopolis.dz_9.task_1;

import java.lang.reflect.InvocationTargetException;

public class App {
    public void useCustomClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String fileName = "ru.innopolis.dz_9.task_1.SomeClass";
        ClassLoader myClassLoader = new MyClassLoader();
        Class<?> loadClass = myClassLoader.loadClass(fileName);
        //Worker someClass = (Worker) loadClass.newInstance();
        loadClass.getMethod("doWork").invoke(loadClass.newInstance());
        //someClass.doWork();
    }


}