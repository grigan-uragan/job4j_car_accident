package ru.grigan.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.grigan.job4j.accident.model.Accident;

import java.util.List;

@Repository
public class AccidentHibernateDAO implements DAO<Accident> {

    private SessionFactory sessionFactory;

    public AccidentHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Accident element) {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(element);
        }
    }

    @Override
    public List<Accident> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "select distinct a from Accident a join fetch a.rules order by a.id",
                    Accident.class).list();
        }
    }

    @Override
    public Accident getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                    "select distinct a from Accident a join fetch a.rules where a.id = :id",
                    Accident.class)
                    .setParameter("id", id).uniqueResult();
        }
    }
}
