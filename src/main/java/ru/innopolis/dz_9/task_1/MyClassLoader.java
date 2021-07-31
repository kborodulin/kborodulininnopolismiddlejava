package ru.innopolis.dz_9.task_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.endsWith("SomeClass.class")) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.endsWith("SomeClass.class")) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(name));
                return defineClass(name.substring(name.indexOf("ru/innopolis"), name.length() - 6)
                        .replace("/", "."), bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}