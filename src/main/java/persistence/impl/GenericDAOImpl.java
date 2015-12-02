package persistence.impl;

import entity.User;
import persistence.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Gui on 30/11/15.
 */
public class GenericDAOImpl implements GenericDAO {

    private EntityManagerFactory emf;

    private EntityManager em;

    public GenericDAOImpl() {
        setUp();

    }

    protected void setUp() {
        try {
            emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        }catch (Exception en){
            en.printStackTrace();
        }
    }

    public User findById(String id) {

        try {
            em = emf.createEntityManager();
            //em.getTransaction().begin();

            //em.getTransaction().commit();
            //em.close();

            return em.find(User.class, Long.parseLong(id));


        }catch (Exception en){
            en.printStackTrace();
        }

        return new User();

    }
}
