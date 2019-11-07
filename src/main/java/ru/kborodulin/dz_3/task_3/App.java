package ru.kborodulin.dz_3.task_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 3. Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
 * Необходимо сделать такую связь, правильно распределить поля и методы. Функциональность в целом должна сохраниться.
 * При попытке положить Object в MathBox должно создаваться исключение.
 */
public class App {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new MathBox( new Number[]{10, 30L, 20, 15, 5, 20, 20.7}));

    }
}
