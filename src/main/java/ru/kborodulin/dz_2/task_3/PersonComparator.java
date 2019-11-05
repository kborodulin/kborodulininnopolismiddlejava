package ru.kborodulin.dz_2.task_3;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int gender = person1.getSex().compareTo(person2.getSex());
        if (gender != 0) return gender;
        int age = person1.getAge() - person2.getAge();
        if (age != 0) return age;
        return person1.getName().compareTo(person2.getName());
    }
}