package demo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.Category;
import demo.model.Stats;
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
	public List<Transaction> getAllTransactions() {
		@SuppressWarnings("unchecked")
		List<Transaction> transactions = sessionFactory.getCurrentSession().createQuery("from transactions").list();
		return transactions;
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> findTransactionsByCategory(Category category) {
		return (List<Transaction>) sessionFactory.getCurrentSession()
				.createQuery("from transactions where category_id=" + category.getId());
	}

	public List<Transaction> findTransactionsByUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Transaction> criteria = builder.createQuery(Transaction.class);
		Root<Transaction> TransactionRoot = criteria.from(Transaction.class);
		criteria.select(TransactionRoot);
		criteria.where(builder.equal(TransactionRoot.get("user"), user));
		List<Transaction> temp = session.createQuery(criteria).getResultList();
		System.out.println(temp);
		return temp;
	}

	public Stats getTransactionStats(User user) {
		List<Transaction> transactions = findTransactionsByUser(user);
		Stats stats = new Stats();
		double expense = 0;
		double income = 0;
		Object obj = new Object();
		for (Transaction transaction : transactions) {
			if (transaction.getTransaction_type().equals("expense")) {
				expense += transaction.getAmount();
			} else {
				income += transaction.getAmount();
			}
		}
		stats.setExpense(expense);
		stats.setIncome(income);
		return stats;
	}
}
