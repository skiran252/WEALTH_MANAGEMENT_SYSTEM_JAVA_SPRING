package demo.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import demo.model.User;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public int save(User user) {

		User temp = findUser(user.getUsername());
		if (temp == null) {
			String encodedPassword = passwordEncoder().encode(user.getPassword());
			user.setPassword(encodedPassword);
			sessionFactory.getCurrentSession().save(user);
			return 1;
		} else {
			return 0;
		}

		
	}

	public User findUser(String username) {
		return sessionFactory.getCurrentSession().find(User.class, username);
	}

	public List<User> list() {
		List<User> usersList = sessionFactory.getCurrentSession().createQuery("from users").list();
		return usersList;
	}
}
