package ru.innopolis.dz_8.task_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
    public static final String CHARSET = "UTF-8";

    public void writeFile(String file, String line) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file), Charset.forName(CHARSET))) {
            writer.write(line);
        }
    }

    public List<String> readFile(String file) throws IOException {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file))) {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
        }
        return strings;
    }
}