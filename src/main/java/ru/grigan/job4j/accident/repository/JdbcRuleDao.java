package ru.grigan.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.Accident;
import ru.grigan.job4j.accident.model.Rule;

import java.util.List;
import java.util.Set;

//@Repository
public class JdbcRuleDao implements DAO<Rule> {

    private JdbcTemplate template;
    private final RowMapper<Rule> ruleRowMapper = (resultSet, rowNum) -> {
        Rule rule = new Rule();
        rule.setId(resultSet.getInt("id"));
        rule.setName(resultSet.getString("name"));
        return rule;
    };

    public JdbcRuleDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void add(Rule element) {
        template.update("insert into rules (id, name) values (?, ?)",
                element.getId(), element.getName());
    }

    @Override
    public List<Rule> getAll() {
        return template.query("select * from rules", ruleRowMapper);
    }

    @Override
    public Rule getById(int id) {
        return template.queryForObject("select * from rules where id = ?", ruleRowMapper, id);
    }

    public List<Rule> getByAccident(Accident accident) {
        return template.query("select r.id, r.name from rules_accident"
                        + " as ra inner join rules as r on ra.rule_id = r.id "
                        + "where ra.accident_id = ?",
                ruleRowMapper, accident.getId());
    }
}
