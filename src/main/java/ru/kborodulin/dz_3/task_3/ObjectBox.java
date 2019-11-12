package ru.kborodulin.dz_3.task_3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ObjectBox<T> {
    private Set<T[]> set = new HashSet();

    public Set getSet() {
        return set;
    }

    public void addObject(T[] object) {
        set.add(object);
    }

    public void deleteObject(T[] object) {
        if (set.contains(object)) {
            set.remove(object);
        }
    }

    public String dump() {
        String str = "";
        for (T[] setConvertArr : set) {
            for (T setConvertStr : setConvertArr) {
                str += setConvertStr + " ";
            }
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(set, objectBox.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "set=" + set +
                '}';
    }
}