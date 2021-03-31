package ru.grigan.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.AccidentType;

import java.util.List;

@Repository
public class AccidentTypeHibernateDAO implements DAO<AccidentType> {

    private SessionFactory sessionFactory;

    public AccidentTypeHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(AccidentType element) {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(element);
        }
    }

    @Override
    public List<AccidentType> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from AccidentType", AccidentType.class).list();
        }
    }

    @Override
    public AccidentType getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(AccidentType.class, id);
        }
    }
}
