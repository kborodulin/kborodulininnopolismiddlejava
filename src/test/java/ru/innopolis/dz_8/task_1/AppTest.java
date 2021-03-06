package ru.innopolis.dz_8.task_1;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AppTest {
    private static final String FILE_NAME = "src/test/java/ru/innopolis/dz_8/task_1/file.txt";

    @Test
    public void serializeTest() throws IOException, InvocationTargetException, IllegalAccessException {
        Person person1 = new Person();
        person1.setId(1);
        person1.setName("Test10");
        person1.setAge(10);

        Passport passport1 = new Passport();
        passport1.setId(100);
        passport1.setSeria("test100");

        person1.setPassport(passport1);

        App app = new App();
        app.serialize(person1, FILE_NAME);
    }

    @Test
    public void deSerialize() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        App app = new App();
        Object object = app.deSerialize(FILE_NAME);
        System.out.println("\n" + object);
    }
}