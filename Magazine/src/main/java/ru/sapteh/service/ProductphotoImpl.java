package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Product;
import ru.sapteh.model.Productphoto;

import java.util.List;

public class ProductphotoImpl implements Dao<Productphoto,Integer> {
    private final SessionFactory factory;

    public ProductphotoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Productphoto> findByAll() {
        try (Session session = factory.openSession()){
            Query<Productphoto> result = session.createQuery("FROM Productphoto ");
            return result.list();

        }
    }

    @Override
    public Productphoto findById(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Productphoto.class, integer);

        }
    }

    @Override
    public void create(Productphoto productphoto) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(productphoto);
            session.getTransaction().commit();

        }
    }

    @Override
    public void update(Productphoto productphoto) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(productphoto);
            session.getTransaction().commit();

        }
    }

    @Override
    public void delete(Productphoto productphoto) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(productphoto);
            session.getTransaction().commit();

        }
    }
}
