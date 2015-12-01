package persistence.impl;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import persistence.GenericDAO;

import java.util.List;

/**
 * Created by Gui on 30/11/15.
 */
public class GenericDAOImpl implements GenericDAO {

    private Session currentSession;

    private Transaction currentTransaction;



    public GenericDAOImpl() {

    }



    public Session openCurrentSession() {

        currentSession = getSessionFactory().openSession();

        return currentSession;

    }



    public Session openCurrentSessionwithTransaction() {

        currentSession = getSessionFactory().openSession();

        currentTransaction = currentSession.beginTransaction();

        return currentSession;

    }



    public void closeCurrentSession() {

        currentSession.close();

    }



    public void closeCurrentSessionwithTransaction() {

        currentTransaction.commit();

        currentSession.close();

    }



    private static SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration().configure();

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()

                .applySettings(configuration.getProperties());

        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        return sessionFactory;

    }



    public Session getCurrentSession() {

        return currentSession;

    }



    public void setCurrentSession(Session currentSession) {

        this.currentSession = currentSession;

    }



    public Transaction getCurrentTransaction() {

        return currentTransaction;

    }



    public void setCurrentTransaction(Transaction currentTransaction) {

        this.currentTransaction = currentTransaction;

    }


    public void persist(User entity) {

        getCurrentSession().save(entity);

    }



    public void update(User entity) {

        getCurrentSession().update(entity);

    }



    public User findById(String id) {

        User book = (User) getCurrentSession().get(User.class, id);

        return book;

    }



    public void delete(User entity) {

        getCurrentSession().delete(entity);

    }



    @SuppressWarnings("unchecked")

    public List<User> findAll() {

        List<User> books = (List<User>) getCurrentSession().createQuery("from User").list();

        return books;

    }



    public void deleteAll() {

        List<User> entityList = findAll();

        for (User entity : entityList) {

            delete(entity);

        }

    }
}
