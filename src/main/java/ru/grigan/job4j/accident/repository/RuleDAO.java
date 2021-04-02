package ru.grigan.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//@Repository
public class RuleDAO implements DAO<Rule> {
    private final Map<Integer, Rule> rules = new HashMap<>();
    private final AtomicInteger countRule = new AtomicInteger();

    @Override
    public void add(Rule rule) {
        rule.setId(countRule.incrementAndGet());
        rules.put(rule.getId(), rule);
    }

    @Override
    public List<Rule> getAll() {
        return new ArrayList<>(rules.values());
    }

    @Override
    public Rule getById(int id) {
        return rules.get(id);
    }
}
