package demo.controller;

import java.io.Serializable;
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
import demo.dao.UserDaoImpl;
import demo.model.Category;
import demo.model.Transaction;

@Controller
public class TransactionController {

	@Autowired
	public UserDaoImpl userDao;

	@Autowired
	public CategoryDao categoryDao;

	@Autowired
	public TransactionDao transactionDao;

	@Transactional
	@GetMapping("/addtransaction")
	public ModelAndView addTransaction(Principal principal, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("transactionpage");
		List<Category> categories = categoryDao.findAll();
		Transaction t = new Transaction();
		t.setUser(userDao.findUser(principal.getName()));
		mav.addObject("transaction", t);
		mav.addObject("categories", categories);
		return mav;
	}

	@Transactional
	@PostMapping("/addtransaction")
	public ModelAndView addTransactionDB(Principal principal, @ModelAttribute Transaction transaction,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("home");

		Date date = new Date();
		transaction.setUser(userDao.findUser(principal.getName()));
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
		ModelAndView mav = new ModelAndView("transactionsviewer");
		List<Transaction> transactions = transactionDao.findByUser(userDao.findUser(principal.getName()));
		mav.addObject("transactions", transactions);
		return mav;
	}
}
