package ru.innopolis.dz_5.task_1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PetFileCabinetTest {
    private static List<Animal> animalInit() {
        List<Animal> animalList = new ArrayList<>();
        Person person1 = new Person("person1", 20, Gender.MAN);
        Animal animal1 = new Animal("animal2", person1, 50);
        animalList.add(animal1);
        Person person2 = new Person("person1", 15, Gender.MAN);
        Animal animal2 = new Animal("animal3", person2, 10);
        animalList.add(animal2);
        Person person3 = new Person("person3", 15, Gender.MAN);
        Animal animal3 = new Animal("animal3", person3, 15);
        animalList.add(animal3);
        Person person4 = new Person("person4", 15, Gender.MAN);
        Animal animal4 = new Animal("animal4", person4, 15);
        animalList.add(animal4);
        Person person5 = new Person("person5", 15, Gender.WOMAN);
        Animal animal5 = new Animal("animal5", person5, 15);
        animalList.add(animal5);
        return animalList;
    }

    private static List<Animal> animalInitDuplicate() {
        List<Animal> animalList = new ArrayList<>();
        Person person1 = new Person("person1", 20, Gender.MAN);
        Animal animal1 = new Animal("animal2", person1, 50);
        animalList.add(animal1);
        Person person2 = new Person("person1", 20, Gender.MAN);
        Animal animal2 = new Animal("animal2", person2, 50);
        animalList.add(animal2);
        return animalList;
    }

    @Test
    public void addAnimalTest() throws Exception {
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        List<Animal> animalList = PetFileCabinetTest.animalInit();
        for (Animal animal : animalList) {
            petFileCabinet.addAnimal(animal);
        }
        petFileCabinet.getAnimalHashMap().forEach((key, value) -> System.out.println(key));
    }

    @Test
    public void addAnimalDuplicateTest() {
        int num = 0;
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        List<Animal> animalList = PetFileCabinetTest.animalInitDuplicate();
        try {
            for (Animal animal : animalList) {
                petFileCabinet.addAnimal(animal);
            }
        } catch (Exception e) {
            System.out.println(e);
            num++;
        }
        Assert.assertEquals(num, 1);
    }

    @Test
    public void findAnimalByName() throws Exception {
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        List<Animal> animalList = PetFileCabinetTest.animalInit();
        for (Animal animal : animalList) {
            petFileCabinet.addAnimal(animal);
        }
        Person person1 = new Person("person3", 15, Gender.MAN);
        Animal animal1 = new Animal("animal3", person1, 15);
        Animal animal2 = petFileCabinet.findAnimalByName("animal3", null);
        Assert.assertEquals(animal1.getPerson(), animal2.getPerson());
        Person person10 = new Person("person3", 15, Gender.MAN);
        Animal animal10 = new Animal("animal3", person1, 15);
        Animal animal20 = petFileCabinet.findAnimalByName("animal3", person10);
        Assert.assertEquals(animal10.getPerson(), animal20.getPerson());
    }

    @Test
    public void renameAnimal() throws Exception {
        int num = 0;
        String uniqueNumber = "";
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        List<Animal> animalList = PetFileCabinetTest.animalInit();
        for (Animal animal : animalList) {
            petFileCabinet.addAnimal(animal);
        }
        Iterator<Map.Entry<String, Animal>> it = petFileCabinet.getAnimalHashMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Animal> pair = it.next();
            Animal animal = pair.getValue();
            num++;
            if (num == 3) {
                uniqueNumber = animal.getUniqueNumber();
                break;
            }
        }
        Person person1 = new Person("person3", 20, Gender.MAN);
        Animal animal1 = new Animal("animal3", person1, 35);
        Animal animal = petFileCabinet.renameAnimal(uniqueNumber, animal1);
        Assert.assertEquals(animal.getName(), animal1.getName());
        Assert.assertEquals(animal.getWeight(), animal1.getWeight());
    }

    @Test
    public void printAnimal() throws Exception {
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        List<Animal> animalList = PetFileCabinetTest.animalInit();
        for (Animal animal : animalList) {
            petFileCabinet.addAnimal(animal);
        }
        petFileCabinet.printAnimal();
    }
}