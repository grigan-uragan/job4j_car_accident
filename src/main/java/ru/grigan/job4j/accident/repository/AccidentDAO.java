package ru.grigan.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.Accident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//@Repository
public class AccidentDAO implements DAO<Accident> {
    private final Map<Integer, Accident> store = new HashMap<>();
    private final AtomicInteger countStore = new AtomicInteger();

    @Override
    public void add(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(countStore.incrementAndGet());
            store.put(accident.getId(), accident);
        } else {
            store.computeIfPresent(accident.getId(), (a, b) -> b = accident);
        }
    }

    @Override
    public List<Accident> getAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Accident getById(int id) {
        return store.get(id);
    }

}
