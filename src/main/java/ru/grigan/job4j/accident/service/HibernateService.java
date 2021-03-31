package ru.grigan.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;
import ru.grigan.job4j.accident.repository.AccidentHibernateDAO;
import ru.grigan.job4j.accident.repository.AccidentTypeHibernateDAO;
import ru.grigan.job4j.accident.repository.RuleHibernateDAO;

import java.util.List;

@Service
public class HibernateService implements AccidentService {

    private AccidentHibernateDAO accidentHibernateDAO;
    private AccidentTypeHibernateDAO typeHibernateDAO;
    private RuleHibernateDAO ruleHibernateDAO;

    public HibernateService(AccidentHibernateDAO accidentHibernateDAO,
                            AccidentTypeHibernateDAO typeHibernateDAO,
                            RuleHibernateDAO ruleHibernateDAO) {
        this.accidentHibernateDAO = accidentHibernateDAO;
        this.typeHibernateDAO = typeHibernateDAO;
        this.ruleHibernateDAO = ruleHibernateDAO;
    }

    @Override
    public void addAccident(Accident accident) {
        accidentHibernateDAO.add(accident);
    }

    @Override
    public List<Accident> getAllAccident() {
        return accidentHibernateDAO.getAll();
    }

    @Override
    public Accident getAccidentById(int id) {
        return accidentHibernateDAO.getById(id);
    }

    @Override
    public void addType(AccidentType type) {
        typeHibernateDAO.add(type);
    }

    @Override
    public List<AccidentType> allType() {
        return typeHibernateDAO.getAll();
    }

    @Override
    public AccidentType getTypeById(int id) {
        return typeHibernateDAO.getById(id);
    }

    @Override
    public void addRule(Rule rule) {
        ruleHibernateDAO.add(rule);
    }

    @Override
    public List<Rule> getAllRule() {
        return ruleHibernateDAO.getAll();
    }

    @Override
    public Rule getRuleById(int id) {
        return ruleHibernateDAO.getById(id);
    }
}
