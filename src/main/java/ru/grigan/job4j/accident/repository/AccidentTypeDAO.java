package ru.grigan.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.AccidentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentTypeDAO implements DAO<AccidentType> {
    private static Map<Integer, AccidentType> types = new HashMap<>();
    private static AtomicInteger countType = new AtomicInteger();

    @Override
    public List<AccidentType> getAll() {
        return new ArrayList<>(types.values());
    }

    @Override
    public void add(AccidentType accidentType) {
        accidentType.setId(countType.incrementAndGet());
        types.put(accidentType.getId(), accidentType);
    }

    @Override
    public AccidentType getById(int id) {
        return types.get(id);
    }
}
