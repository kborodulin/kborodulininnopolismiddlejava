package ru.innopolis.dz_8.task_1;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = -3134155455600680619L;
    private int id;
    private String name;
    private int age;
    private boolean PassportAvailability;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public boolean isPassportAvailability() {
        return PassportAvailability;
    }

    public void setPassportAvailability(boolean passportAvailability) {
        PassportAvailability = passportAvailability;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", PassportAvailability=" + PassportAvailability +
                '}';
    }
}