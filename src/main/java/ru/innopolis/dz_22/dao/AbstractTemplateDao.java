package ru.innopolis.dz_22.dao;

import java.util.List;

public abstract class AbstractTemplateDao<T> {
    abstract void addObject(T obj);

    abstract List<T> getAllObjects();

    abstract void deleteObject(int id);

    abstract void updateObject(T obj);

    abstract T getUserById(int id);
}