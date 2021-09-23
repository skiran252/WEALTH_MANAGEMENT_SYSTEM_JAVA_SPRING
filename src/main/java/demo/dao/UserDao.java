package demo.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.model.User;

@Service
public interface UserDao {

	public int save(User user);

	public List<User> list();

}
