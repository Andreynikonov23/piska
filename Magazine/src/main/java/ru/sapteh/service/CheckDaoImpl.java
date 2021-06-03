package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Check;

import java.util.List;

public class CheckDaoImpl implements Dao<Check, Integer> {
    private final SessionFactory factory;

    public CheckDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Check> findByAll() {
        try (Session session = factory.openSession()){
            Query<Check> result = session.createQuery("FROM Check");
            return result.list();

        }
    }

    @Override
    public Check findById(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Check.class,integer);

        }
    }

    @Override
    public void create(Check check) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(check);
            session.getTransaction().commit();

        }

    }

    @Override
    public void update(Check check) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(check);
            session.getTransaction().commit();

        }


    }

    @Override
    public void delete(Check check) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(check);
            session.getTransaction().commit();

        }


    }
}
