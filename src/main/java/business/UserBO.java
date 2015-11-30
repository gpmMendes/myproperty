package business;

import entity.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserBO {
	
	List<User> list() throws Exception;
	
	User getById(Long id);
	
}

