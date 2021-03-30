package ru.grigan.job4j.accident.config;

import org.springframework.jdbc.core.RowMapper;
import ru.grigan.job4j.accident.model.Accident;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccidentRowMapper implements RowMapper<Accident> {
    @Override
    public Accident mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
