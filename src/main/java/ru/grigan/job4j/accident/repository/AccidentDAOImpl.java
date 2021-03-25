package ru.grigan.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.Accident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccidentDAOImpl implements AccidentDAO {
    private static Map<Integer, Accident> store = new HashMap<>();
    private static int count;

    @Override
    public void addAccident(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(++count);
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
}
