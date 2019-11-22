package ru.innopolis.dz_8.task_1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App implements Serialization {
    @Override
    public void serialize(Object object, String file) throws InvocationTargetException, IllegalAccessException, IOException {
        Json json = new Json();
        Class objectClass = object.getClass();

        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") || method.getName().startsWith("is")) {
                json.jsonFormatUnload(method.getName().substring(3).toLowerCase());
                json.jsonFormatUnload(method.invoke(object).toString());
            }
        }

        FileOperation fileOperation = new FileOperation();
        fileOperation.writeFile(file, json.getBuilder().toString());
        System.out.println();
    }

    @Override
    public Object deSerialize(String file) {

        return null;
    }
}