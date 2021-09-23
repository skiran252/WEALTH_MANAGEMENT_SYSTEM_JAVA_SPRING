package demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.Category;

@Service
public class CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Category> findAll() {
		List<Category> categories = sessionFactory.getCurrentSession().createCriteria(Category.class).list();
		return categories;
	}
	@Transactional
	public Category addCategory(Category category) {
		Category temp = findCategoryByTitle(category.getTitle());
		if (temp != null) {
			return null;
		} else {
			sessionFactory.getCurrentSession().save(category);
			return category;
		}
	}

	@Transactional
	public Category findCategoryByTitle(String title) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class);
		Category temp = (Category) criteria.add(Restrictions.eq("title", title)).uniqueResult();
		return temp;
	}

	@Transactional
	public Category findCategoryById(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Transactional
	public List<Category> fetchAllCategories() {
		@SuppressWarnings("unchecked")
		List<Category> createQuery = (List<Category>) sessionFactory.getCurrentSession().createQuery("from categories");
		return createQuery;
	};

	@Transactional
	void deleteById(Integer id) {
		sessionFactory.getCurrentSession().delete(findCategoryById(id));
	}

	@Transactional
	public void updateCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}
	
	

}
