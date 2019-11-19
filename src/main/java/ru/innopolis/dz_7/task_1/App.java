package ru.innopolis.dz_7.task_1;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static final int FIXEDTHREADPOOL = 10;

    public void appRun(List<Integer> integerList) {
        ExecutorService executorService = Executors.newFixedThreadPool(FIXEDTHREADPOOL);
        for (int i = 0; i < integerList.size(); i++) {
            executorService.submit(new FactorialThread(integerList));
        }
        executorService.shutdown();
    }
}