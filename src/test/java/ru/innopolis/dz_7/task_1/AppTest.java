package ru.innopolis.dz_7.task_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AppTest {
    private static List<Integer> testList = Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16, 17, 18, 19, 20);

    @Test
    public void factorialTest() {
        Factorial factorial = new Factorial();
        Assert.assertEquals("Факториал числа: " + factorial.factorialNumber(5), "Факториал числа: 120");
    }

    @Test
    public void appRunTest() {
        App app = new App();
        List<Integer> list = testList;
        app.appRun(list);
        Factorial.getFactorialMap().forEach((key, value) -> System.out.println(key + " : " + value));
    }
}