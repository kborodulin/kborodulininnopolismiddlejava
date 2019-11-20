package ru.innopolis.dz_7.task_1;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static final int FIXEDTHREADPOOL = 10;
    public static final int FACTORMAXNUMBER = 5000;

    public void appRun(List<Integer> integerList) {
        // Создаем пул потоков
        ExecutorService executorService = Executors.newFixedThreadPool(FIXEDTHREADPOOL);
        // Буферизация массива факториала
        BufferedFactorial bufferedFactorial = new BufferedFactorial();
        for (int num = 0; num < FACTORMAXNUMBER; num++) {
            bufferedFactorial.factorialBufferedNumber(FACTORMAXNUMBER);
        }
        // Вычисление факториала для числа
        for (int num = 0; num < integerList.size(); num++) {
            executorService.submit(new FactorialThread(integerList));
        }
        // Закрываем пул потоков
        executorService.shutdown();
    }
}