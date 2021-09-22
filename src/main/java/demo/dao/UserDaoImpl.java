package demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import demo.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		System.out.println("ENCODED PASSWORD: "+encodedPassword);
		user.setPassword(encodedPassword);
		System.out.println(user);
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<User> list() {
		List<User> usersList = sessionFactory.getCurrentSession().createQuery("from users").list();
		return usersList;
	}

}
