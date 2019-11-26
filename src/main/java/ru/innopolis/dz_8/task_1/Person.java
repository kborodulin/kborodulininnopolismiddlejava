package ru.innopolis.dz_8.task_1;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 553724741462690620L;
    private int id;
    private String name;
    private int age;
    private boolean resident;
    private Passport passport;

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

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", resident=" + resident +
                ", passport=" + passport +
                '}';
    }
}