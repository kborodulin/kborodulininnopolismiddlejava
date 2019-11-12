package ru.innopolis.dz_2.task_3;

/**
 * Сортировка выбором
 */
public class SortSelection implements Sorting {
    @Override
    public Person[] sort() {
        PersonArrays personArrays = new PersonArrays();
        personArrays.arrPersonInit();
        PersonComparator personComparator = new PersonComparator();
        int min = 0;
        Person temp;

        for (int index = 0; index < personArrays.arrPerson.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < personArrays.arrPerson.length; scan++) {
                if (personComparator.compare(personArrays.arrPerson[scan], personArrays.arrPerson[min]) < 0)
                    min = scan;
            }

            temp = personArrays.arrPerson[min];
            personArrays.arrPerson[min] = personArrays.arrPerson[index];
            personArrays.arrPerson[index] = temp;
        }
        return personArrays.arrPerson;
    }
}
