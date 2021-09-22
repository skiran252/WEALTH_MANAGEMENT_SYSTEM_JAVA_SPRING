package demo.dao;

import java.util.List;

import demo.model.User;

public interface UserDao {

	public int save(User user);

	public List<User> list();

}
