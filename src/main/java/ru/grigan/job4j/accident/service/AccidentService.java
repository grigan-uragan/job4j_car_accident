package ru.grigan.job4j.accident.service;

import ru.grigan.job4j.accident.model.Accident;

import java.util.List;

public interface AccidentService {
    void addAccident(Accident accident);

    List<Accident> getAllAccident();

    Accident getAccidentById(int id);
}
