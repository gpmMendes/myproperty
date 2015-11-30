package persistence.impl;

import entity.User;
import persistence.UserDAO;

import javax.ejb.Stateless;

/**
 * Created by Gui on 30/11/15.
 */
@Stateless
public class UserDAOImpl implements UserDAO {
    public User getUser(){
        User user = new User();
        user.setName("Guilherme");
        return user;
    }
}

