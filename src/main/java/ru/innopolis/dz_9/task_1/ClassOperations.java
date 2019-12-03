package ru.innopolis.dz_9.task_1;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClassOperations {
    /**
     * С консоли построчно считывает код метода doWork.
     */
    public List<String> readLinesDoWork() throws IOException {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Пишем метод doWork: ");
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
    public List<String> readSomeClass() throws IOException {
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
    public List<String> writeSomeClass() throws IOException {
        List<String> stringList = new ArrayList<>();
        for (String numStr : readSomeClass()) {
            stringList.add(numStr);
            if (numStr.indexOf("public void doWork()") > 0) {
                stringList.addAll(readLinesDoWork());
            }
        }
        return stringList;
    }

    /**
     * Выгрузим SomeClass.java на диск
     */
    public String someClassUnloadDisk() throws IOException {
        String fileName = "src/test/java/ru/innopolis/dz_9/task_1/" + SomeClass.class.getSimpleName() + ".java";
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8)) {
            for (String line : writeSomeClass()) {
                writer.write(line);
                writer.newLine();
            }
        }
        return fileName;
    }

    /**
     * Скомпилируем SomeClass.java в SomeClass.class
     */
    public String compileSomeClass() throws IOException {
        String fileName = someClassUnloadDisk();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, fileName);
        return fileName.replace(".java", ".class");
    }
}