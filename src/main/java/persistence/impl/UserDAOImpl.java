package persistence.impl;

import entity.User;
import persistence.UserDAO;

/**
 * Created by Gui on 30/11/15.
 */
public class UserDAOImpl implements UserDAO {
    public User getUser(){
        User user = new User();
        user.setName("GUilherme");
        return user;
    }
}

