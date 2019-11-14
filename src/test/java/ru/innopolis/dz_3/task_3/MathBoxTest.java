package ru.innopolis.dz_3.task_3;

import org.junit.Test;

public class MathBoxTest {
    public static Number[] initArrayNumber() {
        Number[] arr = new Number[]{10, 30L, 20, 15, 5, 20, 20.7};
        return arr;
    }

    @Test
    public void addObjectTest() {
        // Number
        ObjectBox<Number> numberObjectBox = new MathBox<>(MathBoxTest.initArrayNumber());
        System.out.println("MathBox: " + ((MathBox<Number>) numberObjectBox).getNumberSet());
        for (Number number : ((MathBox<Number>) numberObjectBox).getNumberSet()) {
            numberObjectBox.addObject(number);
        }
        numberObjectBox.addObject(100);
        numberObjectBox.addObject(101);
        System.out.println("ObjectBox: " + numberObjectBox.getSet());
        // Object
        // ObjectBox<Object> objectObjectBox = new MathBox<Object>(MathBoxTest.initArrayNumber());
    }

    @Test
    public void deleteObjectTest() {
        ObjectBox<Number> numberObjectBox = new MathBox<>(MathBoxTest.initArrayNumber());
        for (Number number : ((MathBox<Number>) numberObjectBox).getNumberSet()) {
            numberObjectBox.addObject(number);
        }
        System.out.println("ObjectBox: " + numberObjectBox.getSet());
        numberObjectBox.deleteObject(20);
        numberObjectBox.deleteObject(15);
        System.out.println("ObjectBox: " + numberObjectBox.getSet());
    }

    @Test
    public void summatorTest() {
        ObjectBox<Number> numberObjectBox = new MathBox<>(MathBoxTest.initArrayNumber());
        System.out.println(((MathBox<Number>) numberObjectBox).summator());
    }

    @Test
    public void dumpTest() {
        ObjectBox<Number> numberObjectBox = new MathBox<>(MathBoxTest.initArrayNumber());
        for (Number number : ((MathBox<Number>) numberObjectBox).getNumberSet()) {
            numberObjectBox.addObject(number);
        }
        numberObjectBox.addObject(105);
        System.out.println(numberObjectBox.dump());
    }
}
