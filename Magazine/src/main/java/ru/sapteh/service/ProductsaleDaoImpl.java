package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Manufacturer;
import ru.sapteh.model.Productsale;

import java.util.List;

public class ProductsaleDaoImpl implements Dao<Productsale,Integer> {
    private final SessionFactory factory;

    public ProductsaleDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Productsale> findByAll() {
        try (Session session = factory.openSession()){
            Query<Productsale> result = session.createQuery("FROM Productsale ");
            return result.list();

        }
    }

    @Override
    public Productsale findById(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Productsale.class, integer);

        }
    }

    @Override
    public void create(Productsale productsale) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(productsale);
            session.getTransaction().commit();

        }

    }

    @Override
    public void update(Productsale productsale) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(productsale);
            session.getTransaction().commit();

        }
    }

    @Override
    public void delete(Productsale productsale) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(productsale);
            session.getTransaction().commit();

        }
    }
}
