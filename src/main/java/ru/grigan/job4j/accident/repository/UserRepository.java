package ru.grigan.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.grigan.job4j.accident.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
