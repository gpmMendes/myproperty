package persistence;

import entity.User;

/**
 * Created by Gui on 30/11/15.
 */
public interface UserDAO extends GenericDAO<User, Long>{
    User getUserById(Long id);
}
