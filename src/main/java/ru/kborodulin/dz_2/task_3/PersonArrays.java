package ru.kborodulin.dz_2.task_3;

public class PersonArrays {
    private int personArraysSize = 10;
    private int personAge = 100;
    public Person[] arrPerson = new Person[personArraysSize];

    public Person[] arrPersonInit() {
        for (int elementPerson = 0; elementPerson < personArraysSize; elementPerson++) {
            arrPerson[elementPerson] = new Person(
                    (int) (Math.random() * personAge),
                    (int) (Math.random() * personAge) > 10 && (int) (Math.random() * personAge) < 20 ||
                            (int) (Math.random() * personAge) > 50 && (int) (Math.random() * personAge) < 70 ? Gender.MAN : Gender.WOMAN,
                    "Test" + elementPerson);
        }

        return arrPerson;
    }
}