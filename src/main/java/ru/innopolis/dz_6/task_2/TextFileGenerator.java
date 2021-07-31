package ru.innopolis.dz_6.task_2;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Генерация текстового файла
 */
public class TextFileGenerator {
    public static final int STRING_LENGTH = 15;
    public static final int ARRAY_WORD_LENGTH = 1000;
    public static final int COUNT_WORD = 15;
    public static final int COUNT_SENTENCE = 20;
    private List<String> wordList = new ArrayList<>();

    public List<String> getWordList() {
        return wordList;
    }

    /**
     * Генератор слов
     */
    public String word() {
        return RandomStringUtils.randomAlphabetic(STRING_LENGTH);
    }

    /**
     * Массив слов
     */
    public void arrWord() {
        for (int count = 0; count < ARRAY_WORD_LENGTH; count++) {
            wordList.add(word());
        }
    }

    /**
     * Генератор слов с вероятностью
     */
    public String wordProbability(int probability) {
        arrWord();
        if (new Random().nextInt(probability + 1) <= probability) {
            return wordList.get(new Random().nextInt(ARRAY_WORD_LENGTH));
        }
        return word();
    }

    /**
     * Генератор предложений
     */
    public String sentence(int probability) {
        String str = "";
        for (int count = 0; count < COUNT_WORD; count++) {
            if (count % 2 == 0) {
                str += wordProbability(probability) + " ";
            } else {
                str += wordProbability(probability) + ", ";
            }
        }
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        str = str.trim();
        int num = new Random().nextInt(3);
        switch (num) {
            case 0:
                str += ". ";
                break;
            case 1:
                str += "! ";
                break;
            case 2:
                str += "? ";
                break;
        }
        return str;
    }

    /**
     * Генератор абзацев
     */
    public String paragraph(int probability) {
        String str = "";
        for (int count = 0; count < COUNT_SENTENCE; count++) {
            str += sentence(probability) + "\r\n";
        }
        return str;
    }

    /**
     * Выгрузка файлов
     *
     * @param path        - Путь до каталога
     * @param n           - Количество файлов
     * @param size        - Размер файла (мб)
     * @param probability - Вероятность
     */
    public void getFiles(String path, int n, int size, int probability) throws IOException {
        for (int numFile = 1; numFile <= n; numFile++) {
            try (FileOutputStream out = new FileOutputStream(path + File.separator + "file" + numFile + ".txt");
                 BufferedOutputStream bos = new BufferedOutputStream(out)) {
                int maxCountBytesFile = size * 1024 * 1024;
                byte[] paragraph = paragraph(probability).getBytes();
                while (maxCountBytesFile > 0) {
                    if (paragraph.length >= maxCountBytesFile) {
                        bos.write(paragraph, 0, maxCountBytesFile);
                        maxCountBytesFile = 0;
                    } else {
                        bos.write(paragraph, 0, paragraph.length);
                        maxCountBytesFile -= paragraph.length;
                    }
                }
            }
        }
    }
}
