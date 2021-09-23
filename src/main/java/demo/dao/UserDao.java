package demo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import demo.model.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public int save(User user) {

		User temp = findUserById(user.getUsername());
		if (temp == null) {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			sessionFactory.getCurrentSession().save(user);
			return 1;
		} else {
			return 0;
		}

	}

	public User findUserById(String username) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, username);
	}

	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> usersList = sessionFactory.getCurrentSession().createQuery("from users").list();
		return usersList;
	}
}
