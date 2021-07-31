package ru.innopolis.dz_7.task_1;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BufferedFactorial {
    private static Map<Integer, BigInteger> factorialBufferedMap = new HashMap<>();
    private BigInteger bigInteger = BigInteger.ONE;

    public static Map<Integer, BigInteger> getFactorialBufferedMap() {
        return factorialBufferedMap;
    }

    public void factorialBufferedNumber(int number) {
        bigInteger = bigInteger.multiply(BigInteger.valueOf(number));
        factorialBufferedMap.put(number, bigInteger);
    }
}