package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Productsale;
import ru.sapteh.model.Producttype;

import java.util.List;

public class ProducttypeDaoImpl implements Dao<Producttype,Integer> {
    private final SessionFactory factory;

    public ProducttypeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Producttype> findByAll() {
        try (Session session = factory.openSession()){
            Query<Producttype> result = session.createQuery("FROM Producttype ");
            return result.list();

        }
    }

    @Override
    public Producttype findById(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Producttype.class, integer);

        }
    }

    @Override
    public void create(Producttype producttype) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(producttype);
            session.getTransaction().commit();

        }
    }

    @Override
    public void update(Producttype producttype) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(producttype);
            session.getTransaction().commit();

        }
    }

    @Override
    public void delete(Producttype producttype) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(producttype);
            session.getTransaction().commit();

        }
    }
}
