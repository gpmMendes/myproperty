package persistence.impl;

import entity.User;
import persistence.UserDAO;

import javax.ejb.Stateless;

/**
 * Created by Gui on 30/11/15.
 */
@Stateless
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    public User getUserById(Long id){
        User user = findById(id);
        return user;
    }
}

