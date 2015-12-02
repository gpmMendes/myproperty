package persistence.impl;

import entity.BaseEntity;
import entity.User;
import persistence.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Gui on 30/11/15.
 */
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    public GenericDAOImpl() {
        setUp();
    }

    protected void setUp() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();
        }catch (Exception en){
            en.printStackTrace();
        }
    }

    private Class<T> persistentClass;

    public GenericDAOImpl(Class<T> persistentClass) {
        setUp();
        this.persistentClass = persistentClass;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Transactional
    public T findById(long id) {
        T entity = (T) getEntityManager().find(getPersistentClass(), id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<T> findAll() {
        return getEntityManager().createQuery("select x from " + getPersistentClass().getSimpleName() + " x")
                .getResultList();
    }

    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public T update(T entity) {
        T mergedEntity = getEntityManager().merge(entity);
        return mergedEntity;
    }

    public void delete(T entity) {
        if (BaseEntity.class.isAssignableFrom(persistentClass)) {
            getEntityManager().remove(entity);
        } else {
            entity = getEntityManager().merge(entity);
            getEntityManager().remove(entity);
        }
    }

    public void flush() {
        getEntityManager().flush();
    }


    public User gui(String id) {

        try {
            return getEntityManager().find(User.class, Long.parseLong(id));


        }catch (Exception en){
            en.printStackTrace();
        }

        return new User();

    }
}
