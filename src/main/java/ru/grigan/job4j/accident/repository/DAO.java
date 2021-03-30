package ru.grigan.job4j.accident.repository;

import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;

import java.util.List;

public interface DAO<T> {
    void add(T element);

    List<T> getAll();

    T getById(int id);
}
