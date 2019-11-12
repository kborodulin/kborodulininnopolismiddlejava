package ru.innopolis.dz_6.task_1;

import org.junit.Test;

import java.io.IOException;
import java.util.Set;

public class FileOperationTest {
    @Test
    public void readLineFileTest() throws IOException {
        FileOperation fileOperation = new FileOperation();
        Set<String> stringSet = fileOperation.readLineFile("src/main/java/ru/innopolis/dz_6/task_1", "products.txt");
        for (String str : stringSet) {
            System.out.println(str);
        }
    }

    @Test
    public void addLineFileTest() throws IOException {
        FileOperation fileOperation = new FileOperation();
        Set<String> stringSet = fileOperation.readLineFile("src/main/java/ru/innopolis/dz_6/task_1", "products.txt");
        fileOperation.addLineFile("src/main/java/ru/innopolis/dz_6/task_1", "rezult.txt", "UTF-8", stringSet);
    }
}