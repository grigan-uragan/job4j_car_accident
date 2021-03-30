package ru.grigan.job4j.accident.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.AccidentType;
import ru.grigan.job4j.accident.model.Rule;

import java.sql.PreparedStatement;
import java.util.*;

@Repository
public class JdbcAccidentDAO implements DAO<Accident> {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcAccidentDAO.class);
    private JdbcTemplate template;
    private JdbcRuleDao ruleDao;
    private JdbcAccidentTypeDAO typeDAO;

    private final RowMapper<Accident> rowMapper = (resultSet, i) -> {
        Accident accident = new Accident();
        accident.setId(resultSet.getInt("id"));
        accident.setName(resultSet.getString("name"));
        accident.setText(resultSet.getString("text"));
        accident.setAddress(resultSet.getString("address"));
        accident.setType(typeDAO.getById(resultSet.getInt("type_id")));
        accident.setRules(new HashSet<>(ruleDao.getByAccident(accident)));
        return accident;
    };

    public JdbcAccidentDAO(JdbcTemplate template, JdbcAccidentTypeDAO typeDAO,
                           JdbcRuleDao ruleDao) {
        this.template = template;
        this.typeDAO = typeDAO;
        this.ruleDao = ruleDao;
    }

    @Override
    public void add(Accident element) {
        AccidentType type = element.getType();
        int typeId;
        if (type == null) {
            typeId = 0;
        } else {
            typeId = type.getId();
        }
        String query = "INSERT INTO accidents (name, text, address, type_id) VALUES (?, ?, ?, ?)";
        KeyHolder holder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement statement =
                    connection.prepareStatement(query, new String[]{"id"});
            statement.setString(1, element.getName());
            statement.setString(2, element.getText());
            statement.setString(3, element.getAddress());
            statement.setInt(4, typeId);
            return statement;
        }, holder);
        element.setId((Integer) holder.getKey());
        addAccidentRules(element);
    }

    @Override
    public List<Accident> getAll() {
        return template.query("select * from accidents", rowMapper);
    }

    @Override
    public Accident getById(int id) {
        return template.queryForObject("select * from accidents where id = ?", rowMapper, id);
    }

    private void addAccidentRules(Accident accident) {
        Set<Rule> rules = accident.getRules();
        for (Rule rule : rules) {
            template.update("insert into rules_accident(rule_id, accident_id) values (?,?)",
                    rule.getId(), accident.getId());
        }
    }
}
