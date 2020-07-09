package model.service;

import model.dao.SessionFactorySingleton;
import model.utils.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GenericService<T> implements IGeneric<T> {

    private SessionFactory sessionFactory;

    public GenericService() {
        SessionFactorySingleton sessionFactorySingleton = SessionFactorySingleton.getInstance();
        sessionFactory = sessionFactorySingleton.getSessionFactory();
    }

    public void add(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        Utils.checkSession(session);
    }

    public void update(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        Utils.checkSession(session);
    }

    public void delete(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        Utils.checkSession(session);
    }

    public T findById(T object, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        object = (T) session.find(object.getClass(), id);
        transaction.commit();
        Utils.checkSession(session);
        return object;
    }

    public List<T> getAll(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName(), object.getClass());
        List<T> results = query.getResultList();
        transaction.commit();
        Utils.checkSession(session);
        return results;
    }

    public List<T> findByColumn(T object, String column1, String column2, String value1, String value2) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where " + column1 +
                "='" + value1 + "'" + " and " + column2 + "='" + value2 + "'");
        List<T> results = query.getResultList();
        transaction.commit();
        Utils.checkSession(session);
        return results;
    }
}
