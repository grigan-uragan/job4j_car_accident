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
            store.put(count++, accident);
    }

    @Override
    public List<Accident> getAllAccident() {
        return new ArrayList<>(store.values());
    }
}
