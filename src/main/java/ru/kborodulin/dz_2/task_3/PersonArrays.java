package ru.kborodulin.dz_2.task_3;

public class PersonArrays {
    public Person[] arrPerson() {
        int personArraysSize = 5;
        Person[] arrPerson = new Person[personArraysSize];

        for (int elementPerson = 0; elementPerson < personArraysSize; elementPerson++) {
            arrPerson[elementPerson] = new Person(
                    (int) (Math.random() * 100),
                    (int) (Math.random() * 100) > 10 && (int) (Math.random() * 100) < 20 ||
                            (int) (Math.random() * 100) > 50 && (int) (Math.random() * 100) < 70 ? Gender.MAN : Gender.WOMAN,
                    "Test" + elementPerson);
        }

        return arrPerson;
    }
}