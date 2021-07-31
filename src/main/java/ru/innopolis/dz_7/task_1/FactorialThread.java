package ru.innopolis.dz_7.task_1;

import java.util.List;

public class FactorialThread implements Runnable {
    private List<Integer> integerList;

    public FactorialThread(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public void run() {
        Factorial factorial = new Factorial();
        factorial.factorialNumberList(integerList);
    }
}