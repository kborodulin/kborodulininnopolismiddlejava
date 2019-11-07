package ru.kborodulin.dz_3.task_2;

import java.util.HashSet;
import java.util.Set;

public class ObjectBox {
    private Set set = new HashSet();

    public Set getSet() {
        return set;
    }

    public void addObject(Object object) {
        set.add(object);
    }

    public void deleteObject(Object object) {
        if (set.contains(object)) {
            set.remove(object);
        }
    }

    public String dump() {
        String str = "";
        for (Object setConvertStr : set) {
            str+= setConvertStr + " ";
        }
        return str;
    }

}
