package ru.grigan.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;
import ru.grigan.job4j.accident.repository.AccidentRepository;
import ru.grigan.job4j.accident.repository.AccidentTypeRepository;
import ru.grigan.job4j.accident.repository.RuleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaService implements AccidentService {

    private AccidentRepository accidentRepository;
    private AccidentTypeRepository typeRepository;
    private RuleRepository ruleRepository;

    public JpaService(AccidentRepository accidentRepository,
                      AccidentTypeRepository typeRepository, RuleRepository ruleRepository) {
        this.accidentRepository = accidentRepository;
        this.typeRepository = typeRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public void addAccident(Accident accident) {
        accidentRepository.save(accident);
    }

    @Override
    public List<Accident> getAllAccident() {
        List<Accident> list = new ArrayList<>();
        for (Accident accident : accidentRepository.findAll()) {
            list.add(accident);
        }
        return list;
    }

    @Override
    public Accident getAccidentById(int id) {
        return accidentRepository.findById(id).get();
    }

    @Override
    public void addType(AccidentType type) {
        typeRepository.save(type);
    }

    @Override
    public List<AccidentType> allType() {
        List<AccidentType> list = new ArrayList<>();
        for (AccidentType type: typeRepository.findAll()) {
            list.add(type);
        }
        return list;
    }

    @Override
    public AccidentType getTypeById(int id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public void addRule(Rule rule) {
        ruleRepository.save(rule);
    }

    @Override
    public List<Rule> getAllRule() {
        List<Rule> list = new ArrayList<>();
        for (Rule rule : ruleRepository.findAll()) {
            list.add(rule);
        }
        return list;
    }

    @Override
    public Rule getRuleById(int id) {
        return ruleRepository.findById(id).get();
    }
}
