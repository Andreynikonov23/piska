package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Manufacturer;
import ru.sapteh.model.Orders;

import java.util.List;

public class OrdersDaoImpl implements Dao<Orders,Integer> {
    private final SessionFactory factory;

    public OrdersDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Orders> findByAll() {
        try (Session session = factory.openSession()){
            Query<Orders> result = session.createQuery("FROM Orders ");
            return result.list();

        }
    }

    @Override
    public Orders findById(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Orders.class, integer);

        }
    }

    @Override
    public void create(Orders orders) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(orders);
            session.getTransaction().commit();

        }

    }

    @Override
    public void update(Orders orders) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(orders);
            session.getTransaction().commit();

        }
    }

    @Override
    public void delete(Orders orders) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(orders);
            session.getTransaction().commit();

        }
    }
}
