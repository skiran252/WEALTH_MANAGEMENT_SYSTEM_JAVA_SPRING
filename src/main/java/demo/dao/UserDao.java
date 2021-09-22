package demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import demo.model.*;

public interface UserDao {

	public void save(User user);
	public List<User> list();

}
