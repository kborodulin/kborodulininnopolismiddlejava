package ru.innopolis.dz_8.task_1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperation {
    public static final String CHARSET = "UTF-8";

    public void writeFile(String file, String line) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file), Charset.forName(CHARSET))) {
            writer.write(line);
            writer.newLine();
        }
    }
}