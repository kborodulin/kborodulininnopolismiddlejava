package ru.innopolis.dz_6.task_2;

import org.junit.Test;

import java.io.IOException;

public class TextFileGeneratorTest {
    private TextFileGenerator initGenerator() {
        TextFileGenerator textFileGenerator = new TextFileGenerator();
        return textFileGenerator;
    }

    @Test
    public void word() {
        System.out.println(initGenerator().word());
    }

    @Test
    public void wordProbability() {
        System.out.println(initGenerator().wordProbability(75));
    }

    @Test
    public void sentence() {
        int probability = 75;
        System.out.println(initGenerator().sentence(probability));
    }

    @Test
    public void paragraph() {
        int probability = 75;
        System.out.println(initGenerator().paragraph(probability).length());
    }

    @Test
    public void getFiles() throws IOException {
        String path = "src/main/java/ru/innopolis/dz_6/task_2";
        int n = 5;
        int size = 2;
        int probability = 75;
        initGenerator().getFiles(path, n, size, probability);
    }
}
