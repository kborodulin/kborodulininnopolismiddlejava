package ru.innopolis.dz_5.task_1;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PetFileCabinetTest {
    @Test
    public void addAnimalTest() throws Exception {
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        Person person1 = new Person("person1", 20, Gender.MAN);
        Animal animal1 = new Animal("animal2", person1, 50);
        petFileCabinet.addAnimal(animal1);
        Person person2 = new Person("person1", 15, Gender.MAN);
        Animal animal2 = new Animal("animal2", person2, 10);
        petFileCabinet.addAnimal(animal2);
        Person person3 = new Person("person3", 15, Gender.MAN);
        Animal animal3 = new Animal("animal3", person3, 15);
        petFileCabinet.addAnimal(animal3);

        for (Animal animal : petFileCabinet.getAnimalList()) {
            System.out.println(animal);
        }
    }

    @Test
    public void addAnimalExceptionTest() throws Exception {
        try {
            PetFileCabinet petFileCabinet = new PetFileCabinet();
            Person person1 = new Person("person1", 20, Gender.MAN);
            Animal animal1 = new Animal("animal2", person1, 50);
            petFileCabinet.addAnimal(animal1);
            Person person4 = new Person("person1", 20, Gender.MAN);
            Animal animal4 = new Animal("animal2", person4, 50);
            petFileCabinet.addAnimal(animal4);
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Животное уже есть в системе!!!"));
        }
    }

    @Test
    public void findAnimalByName() throws Exception {
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        Person person1 = new Person("person1", 20, Gender.MAN);
        Animal animal1 = new Animal("animal2", person1, 50);
        petFileCabinet.addAnimal(animal1);
        Person person2 = new Person("person1", 15, Gender.MAN);
        Animal animal2 = new Animal("animal5", person2, 10);
        petFileCabinet.addAnimal(animal2);
        Person person3 = new Person("person3", 15, Gender.MAN);
        Animal animal3 = new Animal("animal3", person3, 15);
        petFileCabinet.addAnimal(animal3);

        String name = "animal2";
        Animal animal = petFileCabinet.findAnimalByName(name);
        Assert.assertEquals(animal, animal1);
    }

    @Test
    public void renameAnimal() throws Exception {
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        Person person1 = new Person("person1", 20, Gender.MAN);
        Animal animal1 = new Animal("animal2", person1, 50);
        petFileCabinet.addAnimal(animal1);
        Person person2 = new Person("person1", 15, Gender.MAN);
        Animal animal2 = new Animal("animal5", person2, 10);
        petFileCabinet.addAnimal(animal2);
        Person person3 = new Person("person3", 15, Gender.MAN);
        Animal animal3 = new Animal("animal3", person3, 15);
        petFileCabinet.addAnimal(animal3);

        long id = petFileCabinet.getAnimalList().get(1).getUniqueNumber();
        Animal animalOld = petFileCabinet.getAnimalList().get(1);
        System.out.println(animalOld);
        Animal animalNew = petFileCabinet.renameAnimal(id, "test", null, null);
        System.out.println(animalNew);
        Assert.assertEquals(animalOld, animalNew);
    }

    @Test
    public void printAnimal() throws Exception {
        PetFileCabinet petFileCabinet = new PetFileCabinet();
        Person person1 = new Person("person1", 20, Gender.MAN);
        Animal animal1 = new Animal("animal2", person1, 50);
        petFileCabinet.addAnimal(animal1);
        Person person2 = new Person("person1", 15, Gender.MAN);
        Animal animal2 = new Animal("animal5", person2, 10);
        petFileCabinet.addAnimal(animal2);
        Person person3 = new Person("person3", 15, Gender.MAN);
        Animal animal3 = new Animal("animal2", person3, 15);
        petFileCabinet.addAnimal(animal3);
        // До сортировки
        for (Animal animal : petFileCabinet.getAnimalList()) {
            System.out.println(animal);
        }
        // После сортировки
        System.out.println("\n");
        petFileCabinet.printAnimal();
    }
}