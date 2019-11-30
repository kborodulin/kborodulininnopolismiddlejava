package ru.innopolis.dz_9.task_1;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class AppTest {
    @Test
    public void useCustomClassLoader() throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        App app = new App();
        app.useCustomClassLoader();
    }
}
