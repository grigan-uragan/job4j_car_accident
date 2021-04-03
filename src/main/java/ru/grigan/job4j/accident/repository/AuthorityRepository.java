package ru.grigan.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.grigan.job4j.accident.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
