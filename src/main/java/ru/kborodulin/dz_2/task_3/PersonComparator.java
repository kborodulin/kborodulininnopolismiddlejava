package ru.kborodulin.dz_2.task_3;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int gender = person1.getSex().compareTo(person2.getSex());
        int age = 0;
        if (gender == 0) {
            age = person1.getAge() - person2.getAge();
        }

        return age;
    }
}