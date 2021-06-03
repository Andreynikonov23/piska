package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Managers;
import java.util.List;

public class ManagersDaoImpl implements Dao<Managers, Integer> {

    private final SessionFactory factory;
    public ManagersDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public List<Managers> findByAll() {
        try (Session session = factory.openSession()){
            Query<Managers> result = session.createQuery("FROM Managers ");
            return result.list();

        }
    }
    @Override
    public Managers findById(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Managers.class, integer);

        }
    }
    @Override
    public void create(Managers managers) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(managers);
            session.getTransaction().commit();
        }

    }
    @Override
    public void update(Managers managers) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(managers);
            session.getTransaction().commit();
        }
    }
    @Override
    public void delete(Managers managers) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(managers);
            session.getTransaction().commit();
        }
    }
}
