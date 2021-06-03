package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Managers;
import ru.sapteh.model.Manufacturer;

import java.util.List;

public class ManufacturerDaoImpl implements Dao<Manufacturer,Integer> {
    private final SessionFactory factory;

    public ManufacturerDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Manufacturer> findByAll() {
        try (Session session = factory.openSession()){
            Query<Manufacturer> result = session.createQuery("FROM Manufacturer ");
            return result.list();

        }

    }

    @Override
    public Manufacturer findById(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Manufacturer.class, integer);

        }
    }

    @Override
    public void create(Manufacturer manufacturer) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();

        }

    }

    @Override
    public void update(Manufacturer manufacturer) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(manufacturer);
            session.getTransaction().commit();

        }
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(manufacturer);
            session.getTransaction().commit();

        }
    }
}
