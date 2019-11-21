package ru.innopolis.dz_8.task_1;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AppTest {
    private static final String FILE_NAME = "src/test/java/ru/innopolis/dz_8/task_1/file";

    @Test
    public void serializeTest() throws IOException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException {
        Person person1 = new Person();
        person1.setId(1);
        person1.setName("Test10");
        person1.setAge(10);
        App app = new App();
        app.serialize(person1, FILE_NAME);
    }

    @Test
    public void deSerialize() throws IOException, ClassNotFoundException {
        App app = new App();
        System.out.println(app.deSerialize(FILE_NAME));
    }
}