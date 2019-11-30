package ru.innopolis.dz_9.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClassOperations {
    /**
     * С консоли построчно считывает код метода doWork.
     */
    private List<String> readLinesDoWork() throws IOException {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String str = reader.readLine();
                if (str.isEmpty()) break;
                stringList.add(str);

            }
        }
        return stringList;
    }

    /**
     * Считываем класс SomeClass.java
     */
    private List<String> readSomeClass() throws IOException {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/java/" +
                SomeClass.class.getName().replace(".", "/") + ".java"))) {
            while (reader.ready()) {
                stringList.add(reader.readLine());
            }
        }
        return stringList;
    }

    /**
     * Добавляем считанные строки в тело метода public void doWork класса SomeClass.java
     */
    public List<String> whiteSomeClass() throws IOException {
        List<String> stringList = new ArrayList<>();
        for (String numStr : readSomeClass()) {
            stringList.add(numStr);
            if (numStr.indexOf("public void doWork()") > 0) {
                stringList.addAll(readLinesDoWork());
            }
        }
        return stringList;
    }
}