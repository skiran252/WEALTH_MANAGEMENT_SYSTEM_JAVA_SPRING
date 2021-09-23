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
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session.get(User.class, username);
	}

	public List<User> list() {
		List<User> usersList = sessionFactory.getCurrentSession().createQuery("from users").list();
		return usersList;
	}
}
