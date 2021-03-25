package ru.grigan.job4j.accident.repository;

import ru.grigan.job4j.accident.model.Accident;

import java.util.List;

public interface AccidentDAO {
    void addAccident(Accident accident);

    List<Accident> getAllAccident();

    Accident getAccidentById(int id);
}
