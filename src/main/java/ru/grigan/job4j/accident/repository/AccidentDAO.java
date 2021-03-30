package ru.grigan.job4j.accident.repository;

import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;

import java.util.List;

public interface AccidentDAO {
    void addAccident(Accident accident);

    List<Accident> getAllAccident();

    Accident getAccidentById(int id);

    List<AccidentType> getAllTypes();

    void addType(AccidentType accidentType);

    AccidentType getTypeById(int id);

    void addRule(Rule rule);

    List<Rule> getAllRule();

    Rule getRuleById(int id);
}
