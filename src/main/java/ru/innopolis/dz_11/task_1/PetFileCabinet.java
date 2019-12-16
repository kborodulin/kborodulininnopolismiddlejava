package ru.innopolis.dz_11.task_1;

import java.util.*;

/**
 * Картотека домашних животных
 */
public class PetFileCabinet {
    // key -> Кличка; value -> Список хозяинов
    private Map<String, List<Person>> listHashMap = new HashMap<>();
    // key -> Кличка || Кличка + Хозяин || UUID; value -> Животное
    private Map<String, Animal> animalHashMap = new HashMap<>();

    public Map<String, List<Person>> getListHashMap() {
        return listHashMap;
    }

    public Map<String, Animal> getAnimalHashMap() {
        return animalHashMap;
    }

    /**
     * Добавление животного
     */
    public void addAnimal(Animal animal) throws Exception {
        // Проверка животного на дубликат в системе
        if (listHashMap.containsKey(animal.getName())) {
            List<Person> personList = listHashMap.get(animal.getName());
            if (personList.contains(animal.getPerson())) {
                throw new Exception("Животное уже есть в системе!!!" +
                        " Кличка: " + animal.getName() + " Хозяин: " + animal.getPerson());
            }
        }

        // Заполняем отношение Кличка - Список хозяинов
        if (listHashMap.containsKey(animal.getName())) {
            List<Person> personList = listHashMap.get(animal.getName());
            personList.add(animal.getPerson());
        } else {
            List<Person> personList = new ArrayList<>();
            personList.add(animal.getPerson());
            listHashMap.put(animal.getName(), personList);
        }

        animalHashMap.put(animal.getUniqueNumber(), animal);
        animalHashMap.put(animal.getName() + animal.getPerson(), animal);
        animalHashMap.put(animal.getName(), animal);
    }

    /**
     * Поиск животного
     */
    public Animal findAnimalByName(String name, Person person) {
        if (person == null) {
            return animalHashMap.get(name);
        }
        return animalHashMap.get(name + person);
    }

    /**
     * Изменение данных животного по его идентификатору
     */
    public Animal renameAnimal(String uniqueNumber, Animal animalNew) {
        Animal animal = animalHashMap.get(uniqueNumber);
        animal.setName(animalNew.getName());
        animal.setPerson(animalNew.getPerson());
        animal.setWeight(animalNew.getWeight());
        return animal;
    }

    /**
     * Вывод на экран списка животных в отсортированном порядке
     */
    public void printAnimal() {
        Set<Animal> animalSet = new HashSet<>(animalHashMap.values());
        List<Animal> animalList = new ArrayList<>();
        animalList.addAll(animalSet);
        Collections.sort(animalList, new AnimalComparator());
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }
}