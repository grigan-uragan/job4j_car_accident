package ru.grigan.job4j.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
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

    @Override
    public Accident getAccidentById(int id) {
        return accidentDAO.getAccidentById(id);
    }

    @Override
    public void addType(AccidentType type) {
        accidentDAO.addType(type);
    }

    @Override
    public List<AccidentType> allType() {
        return accidentDAO.getAllTypes();
    }
}
