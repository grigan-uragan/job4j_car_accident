package ru.grigan.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;
import ru.grigan.job4j.accident.repository.JdbcAccidentDAO;
import ru.grigan.job4j.accident.repository.JdbcAccidentTypeDAO;
import ru.grigan.job4j.accident.repository.JdbcRuleDao;

import java.util.List;

//@Service
public class JdbcService implements AccidentService {
    private JdbcRuleDao ruleDao;
    private JdbcAccidentTypeDAO typeDAO;
    private JdbcAccidentDAO accidentDAO;

    public JdbcService(JdbcRuleDao ruleDao, JdbcAccidentTypeDAO typeDAO,
                       JdbcAccidentDAO accidentDAO) {
        this.ruleDao = ruleDao;
        this.typeDAO = typeDAO;
        this.accidentDAO = accidentDAO;
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
        ruleDao.add(rule);
    }

    @Override
    public List<Rule> getAllRule() {
        return ruleDao.getAll();
    }

    @Override
    public Rule getRuleById(int id) {
        return ruleDao.getById(id);
    }
}
