package ru.innopolis.dz_15.task_1;

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
