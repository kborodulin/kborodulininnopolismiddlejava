package ru.kborodulin.dz_5.task1;

import java.util.Objects;

/**
 * Животное
 */
public class Animal implements Comparable<Animal> {
    private long uniqueNumber = System.nanoTime();
    private String name;
    private Person person;
    private int weight;

    public Animal(String name, Person person, int weight) {
        this.name = name;
        this.person = person;
        this.weight = weight;
    }

    public long getUniqueNumber() {
        return uniqueNumber;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal animal) {
        return this.name.compareTo(animal.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return weight == animal.weight &&
                Objects.equals(name, animal.name) &&
                Objects.equals(person, animal.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, person, weight);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "uniqueNumber=" + uniqueNumber +
                ", name='" + name + '\'' +
                ", person=" + person +
                ", weight=" + weight +
                '}';
    }
}