package ru.grigan.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.grigan.job4j.accident.model.Rule;

public interface RuleRepository extends CrudRepository<Rule, Integer> {
}
