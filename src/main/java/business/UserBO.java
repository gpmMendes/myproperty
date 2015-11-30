package business;

import entity.User;

import java.util.List;

public interface UserBO {
	
	public List<User> list() throws Exception;
	
	public User getById(Long id);
	
}

