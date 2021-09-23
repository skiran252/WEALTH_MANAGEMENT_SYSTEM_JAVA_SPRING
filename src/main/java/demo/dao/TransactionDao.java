package demo.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.Category;
import demo.model.Transaction;
import demo.model.User;

@Service
public class TransactionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Transaction findById(int id) {
		return sessionFactory.getCurrentSession().find(Transaction.class, id);
	}

	public Transaction addTransaction(Transaction transaction) {
		Serializable status = sessionFactory.getCurrentSession().save(transaction);
		if (status != null)
			return transaction;
		return null;
	}

	@Transactional
	public List<Transaction> findAll() {
		List<Transaction> transactions = sessionFactory.getCurrentSession().createQuery("from transactions").list();
		return transactions;
	}

	public List<Transaction> findByCategory(Category category) {

		return (List<Transaction>) sessionFactory.getCurrentSession()
				.createQuery("from transactions where category_id=" + category.getId());
	}

	public List<Transaction> findByUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		List<Transaction> temp = (List<Transaction>) criteria.add(Restrictions.eq("user", user)).list();
		return temp;
	}
}
