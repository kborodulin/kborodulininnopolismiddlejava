package ru.innopolis.dz_17.task_2;

public enum RoleName {
    ADMINISTRATION("Administration"),
    CLIENTS("Clients"),
    BILLING("Billing");

    private String name;

    RoleName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
