package demo.dao;

import demo.model.Authority;
import demo.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorityDaoimpl {

	@Autowired
	private SessionFactory sessionFactory;

	public void update(Authority authority) {
		sessionFactory.getCurrentSession().update(authority);
	}

	public void save(Authority authority) {
		sessionFactory.getCurrentSession().save(authority);
	}
}
