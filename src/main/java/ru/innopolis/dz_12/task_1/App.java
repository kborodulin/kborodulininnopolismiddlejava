package ru.innopolis.dz_12.task_1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int LOOP_COUNT = 100_000_000;

    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < LOOP_COUNT; i++) {
            if (i % 100_000 == 0) {
                TimeUnit.SECONDS.sleep(1);
            }
            String str = "" + random.nextInt();
            stringBuilder.append(str);
        }
    }
}