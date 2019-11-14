package ru.innopolis.dz_5.task_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Картотека домашних животных
 */
public class PetFileCabinet {
    private List<Animal> animalList = new ArrayList<>();

    public List<Animal> getAnimalList() {
        return animalList;
    }

    /**
     * Добавление животного в список
     */
    public void addAnimal(Animal animal) throws Exception {
        if (animalList.contains(animal)) {
            throw new Exception("Животное уже есть в системе!!!");
        }
        animalList.add(animal);
    }

    /**
     * Поиск животного по имени
     */
    public Animal findAnimalByName(String name) {
        Animal animal = null;
        int index = Collections.binarySearch(animalList, new Animal(name, null, 0), null);
        if (index >= 0) {
            animal = animalList.get(index);
        }
        return animal;
    }

    /**
     * Изменение данных животного по его идентификатору
     */
    public Animal renameAnimal(long id, String name, Person person, Integer weight) {
        Animal animal = null;
        for (Animal animalOld : animalList) {
            if (animalOld.getUniqueNumber() == id) {
                animal = animalOld;
                break;
            }
        }

        if (animal == null) {
            return animal;
        }

        if (name != null) {
            animal.setName(name);
        }

        if (person != null) {
            animal.setPerson(person);
        }

        if (weight != null) {
            animal.setWeight(weight);
        }

        return animal;
    }

    /**
     * Вывод на экран списка животных в отсортированном порядке
     */
    public void printAnimal() {
        Collections.sort(animalList, new AnimalComparator());
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }
}