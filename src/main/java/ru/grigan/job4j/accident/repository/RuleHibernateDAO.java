package ru.grigan.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.grigan.job4j.accident.model.Rule;

import java.util.List;

@Repository
public class RuleHibernateDAO implements DAO<Rule> {

    private SessionFactory sessionFactory;

    public RuleHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Rule element) {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(element);
        }
    }

    @Override
    public List<Rule> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Rule", Rule.class).list();
        }
    }

    @Override
    public Rule getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Rule.class, id);
        }

    }
}
