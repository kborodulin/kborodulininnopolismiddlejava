package ru.innopolis.dz_2.task_2;

import java.util.Random;

public class NumberGenerator {
    public int numberRandom() throws Exception {
        Random random = new Random();
        int number = 100;
        int randomNumber = random.nextInt(number) * (random.nextBoolean() ? -1 : 1);

        if (randomNumber < 0) {
            throw new Exception("Отрицательно число");
        }

        Double squareRoot = Math.sqrt(randomNumber);
        int squareInteger = (int) Math.pow(squareRoot.intValue(), 2);

        if (squareInteger == number) {
            return squareInteger;
        }

        return 0;
    }
}
