package demo.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.dao.CategoryDao;
import demo.dao.TransactionDao;
import demo.dao.UserDao;
import demo.model.Category;
import demo.model.Transaction;
import demo.model.User;

@Controller
public class TransactionController {

	@Autowired
	public UserDao userDao;

	@Autowired
	public CategoryDao categoryDao;

	@Autowired
	public TransactionDao transactionDao;

	@Transactional
	@GetMapping("/addtransaction")
	public ModelAndView addTransaction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("add_transaction");
		List<Category> categories = categoryDao.findAll();
		Transaction t = new Transaction();
		mav.addObject("transaction", t);
		mav.addObject("categories", categories);
		return mav;
	}

	@Transactional
	@PostMapping("/addtransaction")
	public ModelAndView addTransactionDB(Principal principal, @ModelAttribute Transaction transaction,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("dashboard");

		Date date = new Date();
		User currentUser = userDao.findUserById(principal.getName());
		System.out.println(currentUser);
		transaction.setUser(userDao.findUserById(principal.getName()));
		transaction.setTransactionDate(date);
		int category_id = Integer.parseInt(transaction.getCategory_name());
		transaction.setCategory(categoryDao.findCategoryById(category_id));
		Transaction obj = transactionDao.addTransaction(transaction);
		if (obj != null) {
			mav.addObject("message", "Transaction Added Successfully");
		} else {
			mav.addObject("error", "cannot add transaction");
		}
		return mav;
	}

	@Transactional
	@GetMapping("/transactions")
	public ModelAndView showTransactions(Principal principal, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("transactions");
		System.out.println(principal.getName());
		User currentUser = userDao.findUserById(principal.getName());
		System.out.println(currentUser);
		List<Transaction> transactions = transactionDao.findTransactionsByUser(currentUser);
		mav.addObject("transactions", transactions);
		return mav;
	}
}
