package ru.innopolis.dz_8.task_1;

import java.io.*;

public class App implements Serialization {
    @Override
    public void serialize(Object object, String file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        }
    }

    @Override
    public Object deSerialize(String file) throws IOException, ClassNotFoundException {
        Person personNew;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            personNew = (Person) objectInputStream.readObject();
        }
        return personNew;
    }
}