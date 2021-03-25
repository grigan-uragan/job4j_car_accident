package ru.grigan.job4j.accident.service;

import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;

import java.util.List;

public interface AccidentService {
    void addAccident(Accident accident);

    List<Accident> getAllAccident();

    Accident getAccidentById(int id);

    void addType(AccidentType type);

    List<AccidentType> allType();

    AccidentType getTypeById(int id);
}
