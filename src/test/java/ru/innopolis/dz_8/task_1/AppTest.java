package ru.innopolis.dz_8.task_1;

import org.junit.Test;

import java.io.IOException;

public class AppTest {
    private static final String FILE_NAME = "src/test/java/ru/innopolis/dz_8/task_1/file";

    @Test
    public void serializeTest() throws IOException {
        Person person = new Person();
        person.setId(2);
        person.setName("Test10");
        person.setAge(20);
        App app = new App();
        app.serialize(person, FILE_NAME);
    }

    @Test
    public void deSerialize() throws IOException, ClassNotFoundException {
        App app = new App();
        System.out.println(app.deSerialize(FILE_NAME));
    }
}