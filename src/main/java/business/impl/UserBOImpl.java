package business.impl;

import business.UserBO;
import entity.User;
import persistence.UserDAO;

import java.io.Serializable;
import java.util.List;

public class UserBOImpl implements UserBO, Serializable {

	private static final long serialVersionUID = -7181845834876407823L;
	
	private UserDAO userDAO;

	public List<User> list() throws Exception {
		return list();
	}

	public User getById(Long id) {
		try {
			return userDAO.getUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
