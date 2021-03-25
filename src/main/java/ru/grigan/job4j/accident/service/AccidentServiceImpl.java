package ru.grigan.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.repository.AccidentDAO;

import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {
    @Autowired
    private AccidentDAO accidentDAO;

    @Override
    public void addAccident(Accident accident) {
        accidentDAO.addAccident(accident);
    }

    @Override
    public List<Accident> getAllAccident() {
        return accidentDAO.getAllAccident();
    }
}
