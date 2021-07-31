package ru.innopolis.dz_3.task_3;

import java.util.HashSet;
import java.util.Set;

public class ObjectBox<T> {
    private Set<T> set = new HashSet();

    public Set<T> getSet() {
        return set;
    }

    public void addObject(T object) {
        set.add(object);
    }

    public void deleteObject(T object) {
        set.remove(object);
    }

    public String dump() {
        String str = "";
        for (T setConvertStr : set) {
            str += setConvertStr + " ";
        }
        return str;
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "set=" + set +
                '}';
    }
}