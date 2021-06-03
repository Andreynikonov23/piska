package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Check;
import ru.sapteh.model.Gender;

import java.util.List;

public class GenderDaoImpl implements Dao<Gender, Integer> {
    private final SessionFactory factory;

    public GenderDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Gender> findByAll() {
        try (Session session = factory.openSession()){
            Query<Gender> result = session.createQuery("FROM Gender ");
            return result.list();


        }

    }

    @Override
    public Gender findById(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Gender.class,integer);

        }
    }

    @Override
    public void create(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(gender);
            session.getTransaction().commit();

        }

    }

    @Override
    public void update(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(gender);
            session.getTransaction().commit();

        }

    }

    @Override
    public void delete(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(gender);
            session.getTransaction().commit();

        }

    }
}
