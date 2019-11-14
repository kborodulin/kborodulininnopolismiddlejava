package ru.innopolis.dz_3.task_3;

import ru.innopolis.dz_3.task_1.ServiceNumber;

import java.util.*;

public class MathBox<T extends Number> extends ObjectBox<T> {
    private Set<T> numberSet = new HashSet<>();

    public Set<T> getNumberSet() {
        return numberSet;
    }

    public MathBox(T[] arrNumbers) {
        for (T number : arrNumbers) {
            numberSet.add(number);
        }
    }

    public double summator() {
        double totalSum = 0d;
        for (T number : numberSet) {
            totalSum += number.doubleValue();
        }
        return totalSum;
    }

    public void deleteValueCollectionForInteger() {
        for (Iterator<T> iterator = numberSet.iterator(); iterator.hasNext(); ) {
            Number element = iterator.next();
            if (element instanceof Integer) {
                iterator.remove();
            }
        }
    }

    public void splitter(T divider) {
        Set<T> numberSetTmp = new HashSet<>();
        for (Iterator<T> iterator = numberSet.iterator(); iterator.hasNext(); ) {
            T element = iterator.next();
            numberSetTmp.add((T) ServiceNumber.checkNumber(element, divider));
            iterator.remove();
        }
        numberSet.addAll(numberSetTmp);
    }

    @Override
    public void addObject(T object) {
        super.addObject(object);
    }

    @Override
    public void deleteObject(T object) {
        super.deleteObject(object);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numberSet=" + numberSet +
                '}';
    }
}