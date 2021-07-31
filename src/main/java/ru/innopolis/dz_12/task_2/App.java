package ru.innopolis.dz_12.task_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Эта память хранит метаданные загруженных классов
 * https://topjava.ru/blog/permgen-and-metaspace
 * Permanent - до 8
 * Metaspace - с 8
 */
public class App {
    private static final int LOOP_COUNT = 100_000_000;

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();

        for (int i = 0; i < LOOP_COUNT; i++) {
            objectList.add(new Object());
        }
    }
}