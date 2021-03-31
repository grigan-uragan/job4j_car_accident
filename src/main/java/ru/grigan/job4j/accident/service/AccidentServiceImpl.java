package ru.grigan.job4j.accident.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;
import ru.grigan.job4j.accident.repository.AccidentDAO;
import ru.grigan.job4j.accident.repository.AccidentTypeDAO;
import ru.grigan.job4j.accident.repository.RuleDAO;

import java.util.List;
import java.util.Set;

//@Service
public class AccidentServiceImpl implements AccidentService {

    private AccidentDAO accidentDAO;
    private AccidentTypeDAO typeDAO;
    private RuleDAO ruleDAO;

    public AccidentServiceImpl(AccidentDAO accidentDAO, AccidentTypeDAO typeDAO, RuleDAO ruleDAO) {
        this.accidentDAO = accidentDAO;
        this.typeDAO = typeDAO;
        this.ruleDAO = ruleDAO;
        init();
    }

    private void init() {
        addType(new AccidentType("two cars"));
        addType(new AccidentType("Bike and car"));
        addRule(new Rule("rule 1.1"));
        addRule(new Rule("rule 1.2"));
        addRule(new Rule("rule 2.1"));
        addRule(new Rule("rule 2.1.3"));
        addRule(new Rule("rule 3.1"));
        addAccident(new Accident("first accident",
                "speed limit over",
                "Lenin street",
                getTypeById(1),
                Set.of(getRuleById(1), getRuleById(2))));
        addAccident(new Accident("second accident",
                "driving to a stoplight signal",
                "Gagarin street",
                getTypeById(2),
                Set.of(getRuleById(3), getRuleById(4))));
    }

    @Override
    public void addAccident(Accident accident) {
        accidentDAO.add(accident);
    }

    @Override
    public List<Accident> getAllAccident() {
        return accidentDAO.getAll();
    }

    @Override
    public Accident getAccidentById(int id) {
        return accidentDAO.getById(id);
    }

    @Override
    public void addType(AccidentType type) {
        typeDAO.add(type);
    }

    @Override
    public List<AccidentType> allType() {
        return typeDAO.getAll();
    }

    @Override
    public AccidentType getTypeById(int id) {
        return typeDAO.getById(id);
    }

    @Override
    public void addRule(Rule rule) {
        ruleDAO.add(rule);
    }

    @Override
    public List<Rule> getAllRule() {
        return ruleDAO.getAll();
    }

    @Override
    public Rule getRuleById(int id) {
        return ruleDAO.getById(id);
    }
}
