package ru.grigan.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentDAOImpl implements AccidentDAO {
    private static Map<Integer, Accident> store = new HashMap<>();
    private static Map<Integer, AccidentType> types = new HashMap<>();
    private static Map<Integer, Rule> rules = new HashMap<>();
    private static AtomicInteger countStore = new AtomicInteger();
    private static AtomicInteger countType = new AtomicInteger();
    private static AtomicInteger countRule = new AtomicInteger();

    public AccidentDAOImpl() {
        addType(new AccidentType("two cars"));
        addType(new AccidentType("Bike and car"));
        addAccident(new Accident("first accident", "speed limit over",
                "Lenin street", getTypeById(1)));
        addAccident(new Accident("second accident", "driving to a stoplight signal",
                "Gagarin street", getTypeById(2)));
        addRule(new Rule("rule 1.1"));
        addRule(new Rule("rule 1.2"));
        addRule(new Rule("rule 2.1"));
        addRule(new Rule("rule 2.1.3"));
        addRule(new Rule("rule 3.1"));
    }

    @Override
    public void addAccident(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(countStore.incrementAndGet());
            store.put(accident.getId(), accident);
        } else {
            store.computeIfPresent(accident.getId(), (a, b) -> b = accident);
        }

    }

    @Override
    public List<Accident> getAllAccident() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Accident getAccidentById(int id) {
        return store.get(id);
    }

    @Override
    public List<AccidentType> getAllTypes() {
        return new ArrayList<>(types.values());
    }

    @Override
    public void addType(AccidentType accidentType) {
        accidentType.setId(countType.incrementAndGet());
        types.put(accidentType.getId(), accidentType);
    }

    @Override
    public AccidentType getTypeById(int id) {
        return types.get(id);
    }

    @Override
    public void addRule(Rule rule) {
        rule.setId(countRule.incrementAndGet());
        rules.put(rule.getId(), rule);
    }

    @Override
    public List<Rule> getAllRule() {
        return new ArrayList<>(rules.values());
    }

    @Override
    public Rule getRuleById(int id) {
        return rules.get(id);
    }
}
