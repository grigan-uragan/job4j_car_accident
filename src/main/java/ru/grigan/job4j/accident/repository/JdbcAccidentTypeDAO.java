package ru.grigan.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.AccidentType;

import java.util.List;

//@Repository
public class JdbcAccidentTypeDAO implements DAO<AccidentType> {
    private JdbcTemplate template;
    private final RowMapper<AccidentType> rowMapper = (resultSet, i) -> {
        AccidentType type = new AccidentType();
        type.setId(resultSet.getInt("id"));
        type.setName(resultSet.getString("name"));

        return type;
    };

    public JdbcAccidentTypeDAO(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void add(AccidentType element) {
        template.update("INSERT INTO types (id, name) VALUES (?, ?)",
                element.getId(), element.getName());
    }

    @Override
    public List<AccidentType> getAll() {
        return template.query("SELECT * FROM types", rowMapper);
    }

    @Override
    public AccidentType getById(int id) {
        return template.queryForObject("SELECT * FROM types WHERE id = ?", rowMapper, id);
    }
}
