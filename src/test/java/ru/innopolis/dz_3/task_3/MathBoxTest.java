package ru.innopolis.dz_3.task_3;

import org.junit.Test;

public class MathBoxTest {
    @Test
    public void addObjectTest() {
        Number[] arr = new Number[]{10, 30L, 20, 15, 5, 20, 20.7};
        Object[] obj = new Object[]{10, 30L, 20, 15, 5, 20, 20.7};
        ObjectBox<Number> numberObjectBox = new MathBox<>(arr);
        numberObjectBox.addObject(arr);
        // numberObjectBox.addObject(obj);
    }

    @Test
    public void deleteObjectTest() {
        Number[] arr = new Number[]{10, 30L, 20, 15, 5, 20, 20.7};
        Object[] obj = new Object[]{10, 30L, 20, 15, 5, 20, 20.7};
        ObjectBox<Number> numberObjectBox = new MathBox<>(arr);
        numberObjectBox.addObject(arr);
        numberObjectBox.deleteObject(arr);
        // numberObjectBox.addObject(obj);
    }

    @Test
    public void summatorTest() {
        Number[] arr = new Number[]{10, 30L, 20, 15, 5, 20, 20.7};
        ObjectBox<Number> numberObjectBox = new MathBox<>(arr);
        System.out.println(((MathBox<Number>) numberObjectBox).summator());
    }

    @Test
    public void dumpTest() {
        Number[] arr = new Number[]{10, 30L, 20, 15, 5, 20, 20.7};
        ObjectBox<Number> numberObjectBox = new MathBox<>(arr);
        numberObjectBox.addObject(arr);
        System.out.println(numberObjectBox.dump());
    }
}
