package persistence.impl;

import entity.User;
import persistence.UserDAO;

import javax.ejb.Stateless;

/**
 * Created by Gui on 30/11/15.
 */
@Stateless
public class UserDAOImpl extends GenericDAOImpl implements UserDAO {

    public User getUser(){
        User user = findById("1");
        return user;
    }
}

