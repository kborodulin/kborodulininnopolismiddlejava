package ru.innopolis.dz_6.task_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/**
 * Операции с файлом
 */
public class FileOperation {
    /**
     * Чтение файла
     */
    public Set readLineFile(String pathFile, String fileName) throws IOException {
        Set<String> stringSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathFile + File.separator + fileName))) {
            while (reader.ready()) {
                String[] splitStr = reader.readLine().trim().split("\\s+");
                for (String str : splitStr) {
                    stringSet.add(str);
                }
            }
        }
        return stringSet;
    }

    /**
     * Запись файла
     */
    public void addLineFile(String pathFile, String fileName, String charset, Set<String> set) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(pathFile + File.separator + fileName),
                Charset.forName(charset))) {
            for (String line : set) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}