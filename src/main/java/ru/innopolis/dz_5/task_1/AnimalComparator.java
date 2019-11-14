package ru.innopolis.dz_5.task_1;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        int namePerson = animal1.getPerson().getName().compareTo(animal2.getPerson().getName());
        if (namePerson != 0) return namePerson;
        int nameAnimal = animal1.getName().compareTo(animal2.getName());
        if (nameAnimal != 0) return nameAnimal;
        return animal1.getWeight() - animal2.getWeight();
    }
}