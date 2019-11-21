package ru.innopolis.dz_8.task_1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Serialization {
    /**
     * Сериализация объекта в файл
     */
    void serialize(Object object, String file) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException;

    /**
     * Десериализация объекта из файла
     */
    Object deSerialize(String file) throws IOException, ClassNotFoundException;
}