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

    @Override
    public void addObject(T[] object) {
        super.addObject(object);
    }

    @Override
    public void deleteObject(T[] object) {
        super.deleteObject(object);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return Objects.equals(numberSet, mathBox.numberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberSet);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numberSet=" + numberSet +
                '}';
    }
}