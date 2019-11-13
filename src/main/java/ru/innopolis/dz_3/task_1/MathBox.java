package ru.innopolis.dz_3.task_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class MathBox {
    private Set<Number> numberSet = new HashSet<>();

    public Set<Number> getNumberSet() {
        return numberSet;
    }

    public MathBox(Number[] arrNumbers) {
        for (Number number : arrNumbers) {
            numberSet.add(number);
        }
    }

    public double summator() {
        double totalSum = 0d;
        for (Number number : numberSet) {
            totalSum += number.doubleValue();
        }
        return totalSum;
    }

    public void splitter(Number divider) {
        Set<Number> numberSetTmp = new HashSet<>();
        for (Iterator<Number> iterator = numberSet.iterator(); iterator.hasNext(); ) {
            Number element = iterator.next();
            numberSetTmp.add(ServiceNumber.checkNumber(element, divider));
            iterator.remove();
        }
        numberSet.addAll(numberSetTmp);
    }

    public void deleteValueCollectionForInteger() {
        for (Iterator<Number> iterator = numberSet.iterator(); iterator.hasNext(); ) {
            Number element = iterator.next();
            if (element instanceof Integer) {
                iterator.remove();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(numberSet, mathBox.numberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberSet);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numberSet=" + numberSet +
                '}';
    }
}