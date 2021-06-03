package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Check;
import ru.sapteh.model.Client;

import java.util.List;

public class ClientDaoImpl implements Dao<Client, Integer> {
    private final SessionFactory factory;

    public ClientDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Client> findByAll() {
        try (Session session = factory.openSession()) {
            Query<Client> result = session.createQuery("FROM Client ");
            return result.list();
        }
    }

    @Override
    public Client findById(Integer integer) {
        try (Session session = factory.openSession()) {
            return session.get(Client.class, integer);
        }
    }

        @Override
        public void create (Client client){
            try (Session session = factory.openSession()){
                session.beginTransaction();
                session.save(client);
                session.getTransaction().commit();

            }

        }

        @Override
        public void update (Client client){
            try (Session session = factory.openSession()){
                session.beginTransaction();
                session.update(client);
                session.getTransaction().commit();

            }

        }

        @Override
        public void delete (Client client){
            try (Session session = factory.openSession()){
                session.beginTransaction();
                session.delete(client);
                session.getTransaction().commit();

            }

        }

}

