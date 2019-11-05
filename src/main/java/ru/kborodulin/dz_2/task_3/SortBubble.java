package ru.kborodulin.dz_2.task_3;

/**
 * Сортировка пузырьком
 */
public class SortBubble implements Sorting {
    @Override
    public Person[] sort() {
        PersonArrays personArrays = new PersonArrays();
        personArrays.arrPersonInit();
        PersonComparator personComparator = new PersonComparator();
        boolean isSorted = false;
        Person buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < personArrays.arrPerson.length - 1; i++) {
                if (personComparator.compare(personArrays.arrPerson[i], personArrays.arrPerson[i + 1]) > 0) {
                    isSorted = false;

                    buf = personArrays.arrPerson[i];
                    personArrays.arrPerson[i] = personArrays.arrPerson[i + 1];
                    personArrays.arrPerson[i + 1] = buf;
                }
            }
        }

        return personArrays.arrPerson;
    }
}
