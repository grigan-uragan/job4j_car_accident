package ru.grigan.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.grigan.job4j.accident.model.Accident;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

}
