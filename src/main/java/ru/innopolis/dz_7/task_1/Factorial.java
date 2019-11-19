package ru.innopolis.dz_7.task_1;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Factorial {
    private static ConcurrentHashMap<Integer, BigInteger> factorialMap = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<Integer, BigInteger> getFactorialMap() {
        return factorialMap;
    }

    public BigInteger factorialNumber(int number) {
        BigInteger bigInteger = BigInteger.ONE;
        if (factorialMap.containsKey(number)) {
            return factorialMap.get(number);
        }
        for (int fact = 1; fact <= number; fact++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(fact));
        }
        factorialMap.put(number, bigInteger);
        return bigInteger;
    }

    public void factorialNumberList(List<Integer> integerList) {
        for (Integer number : integerList) {
            factorialNumber(number);
        }
    }
}